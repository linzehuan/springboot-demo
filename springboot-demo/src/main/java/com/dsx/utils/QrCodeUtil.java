package com.dsx.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Hashtable;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 二维码生成工具类
 * @author an
 *
 */
public class QrCodeUtil {
	
	/**
     * 生成二维码
     * David
     * @param url  url 网址
     * @param width     二维码宽度
     * @param height    二维码高度
     * @param imgPath   生成的二维码url: 路径+文件名
     */
    public static void encode(String url, int width, int height, String imgPath) {

        Map<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();

        // 指定纠错等级

        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

        // 指定编码格式

        hints.put(EncodeHintType.CHARACTER_SET, "UTF8");

        try {

            BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height, hints);

            MatrixToImageWriter.writeToStream(bitMatrix, "png", new FileOutputStream(imgPath));

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    /**
     * 二维码解析
     * David
     * @param imgPath   二维码图片 路径+文件名
     * @return          解析后的二维码内容
     */

    public static String decode(String imgPath) {

        BufferedImage image = null;

        Result result = null;

        try {

            image = ImageIO.read(new File(imgPath));

            if (image == null) {

                return "the decode image may be not exit";

            }

            LuminanceSource source = new BufferedImageLuminanceSource(image);

            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            Map<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();

            hints.put(DecodeHintType.CHARACTER_SET, "UTF8");

            result = new MultiFormatReader().decode(bitmap, hints);

            return result.getText();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }

    // 测试代码
    public static void main( String[] args ){

    	  QrCodeUtil.encode("https://www.desire.ren/app?serverId=123&flag=1", 500, 500, "E:\\CodeImg\\QrCode.png");
//        System.out.println(QrCodeUtil.decode("D:\\David\\QrCode\\QrCode1.png"));

    }

}
