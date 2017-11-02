package io.stephen.security.demo;

import com.fasterxml.jackson.annotation.JsonView;
import io.stephen.security.dto.User;
import io.stephen.security.exceptionHandle.CommonException;
import org.apache.commons.io.IOUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 10447
 * @since 2017/10/29
 */
@RestController
@RequestMapping("/user")
public class DemoController {

    private String filePath = "C:\\Users\\10447\\Documents";



    @GetMapping("/ex")
    public void testException() throws Exception {
        throw new CommonException("1212");
    }


    @PostMapping("/file")
    public Map<String, Object> upload(MultipartFile multicastFile) throws IOException {

        System.out.println("名字："+multicastFile.getName());
        System.out.println(multicastFile.getSize());

        File file = new File(filePath, multicastFile.getName()+".txt");

        multicastFile.transferTo(file);

        Map<String, Object> map = new HashMap<>();
        map.put("path", filePath + multicastFile.getName());
        return map;
    }

    /**
     * 下载
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try (InputStream inputStream = new FileInputStream(new File(filePath+"\\user.sql"));
            OutputStream outputStream= response.getOutputStream();
        ) {

            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition","attachment;filename=user.sql");
            IOUtils.copy(inputStream, outputStream);

            outputStream.flush();
        }
    }


    /**
     * @param user
     * @param errors
     * @return
     * @Valid 开启 notBlock注解验证，BindingResult为验证错误信息结果
     */
    @PostMapping
    public User validData(@Valid @RequestBody User user, BindingResult errors) {

        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> {

                FieldError fieldError = (FieldError) error;

                System.out.println(fieldError.getDefaultMessage());

            });
        }

        user.setId("1");
        return user;
    }


    /**
     * 注解@PathVariable 获取RESUful请求参数到方法参数上
     *
     * @param id
     * @return
     */
    @GetMapping("/{id:\\d+}")
    @JsonView(User.userDetailView.class)
    public User getInfo(@PathVariable String id) {

        User user = new User();
        user.setId(id);
        user.setPassword("12312");
        user.setUsername("stephen");
        return user;
    }


    /**
     * 注解@RequestParam 简单的请求参数获取
     *
     * @param param
     * @return
     */
    @GetMapping
    @JsonView(User.userSimpleView.class)
    public User hello(@RequestParam() Map<String, Object> param) {
        System.out.println("得到的：" + param);

        User user = new User();
        user.setId((String) param.get("id"));
        user.setPassword("12312");
        user.setUsername("stephen");
        return user;
    }


}
