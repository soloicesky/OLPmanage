package com.onlinepay.manage.web.system.controller;

import com.onlinepay.manage.web.system.enums.LoginEnums;
import com.onlinepay.manage.web.util.SecurityCode;
import com.onlinepay.manage.web.util.SecurityImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * TODO:生成验证码
 * Created by tom on 17/7/5.
 */
@Controller
@RequestMapping("common")
public class SecurityCodeController {
    private static final Logger log = LoggerFactory.getLogger(SecurityCodeController.class);

    @RequestMapping("securityCode")
    @ResponseBody
    public void securityCode(HttpSession session, HttpServletResponse response) throws IOException {
        String code = SecurityCode.getSecurityCode();
        session.setAttribute(LoginEnums.PIC_VERIFICATION_CODE.getKey(), code);
        // 利用图片工具生成图片
        BufferedImage image = SecurityImage.createImage(code);
        OutputStream os = response.getOutputStream();
        ImageIO.write(image, "png", os);
    }
}
