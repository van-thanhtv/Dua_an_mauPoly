/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import model.nhanVien;

/**
 *
 * @author Tran Van Thanh
 */
//Chứa thông tin người dùng sau khi đăng nhập và đăng xuất
//Set logo cho tất cả From
public class shareHelper {

    //* Ảnh biểu tượng của ứng dụng, xuất hiện trên mọi cửa sổ
    public static final Image APP_ICON;
    public static final ImageIcon APP_ICON1;
    //khi chạy thì chạy static đầu tiên

    static {
        // Tải biểu tượng ứng dụng 
        //CÁCH TẢI ẢNH TỪ TRONG PROJECT
        //icon là thư mục con của src
        //Logo cho ứng dụng
        String file = "/icon/logo.png";      //icon là thư mục con của src
        APP_ICON = new ImageIcon(shareHelper.class.getResource(file)).getImage();
        APP_ICON1 = new ImageIcon(shareHelper.class.getResource(file));//getResource(file) Tìm 1 tài nguyên với 1 tên nhất định Trả về 1 đối tượng URL hoặc null
    }
    /**
     * Sao chép file logo FPT vào thư mục logos (tạo nếu chưa có thư mục logos)
     * @param file là đối tượng file ảnh
     * @return chép được hay không
     */
    public static boolean saveLogo(File file){
        File dri = new File("logos");//khai báo thư mục logos ngang hàng với src
        // Tạo thư mục nếu chưa tồn tại
        if (!dri.exists()) {//exists() Để kiểm tra Thư mục này có tồn tại hay là không
            dri.mkdirs();//Tạo thư mục được đặt tên bởi tên đường dẫn trừu tượng này
        }
        File newFile= new File(dri, file.getName());
        try {
            // Copy vào thư mục logos (đè nếu đã tồn tại)
            Path source = Paths.get(file.getAbsolutePath());//Trả về chuỗi tên đường dẫn tuyệt đối của tên đường dẫn trừu tượng này.
            Path destination = Paths.get(newFile.getAbsolutePath());
            Files.copy(source, destination,StandardCopyOption.REPLACE_EXISTING);//Thực hiên copy File
            return true;
        } catch (Exception e) {
            return false;
        }
    }
     /**
     * Đọc hình ảnh logo chuyên đề trong thư mục logos theo tenFile
     * @param fileName là tên file logo
     * @return ImageIcon ảnh đọc được
     */
    public static ImageIcon readLogo(String fileName){
        File path = new File("logos", fileName);
        return new ImageIcon(new ImageIcon(path.getAbsolutePath()).getImage().getScaledInstance(180, 180,Image.SCALE_DEFAULT));
    }
    //Phương thức này chứa thông tin người sử dụng sau khi đăng nhập
    public static nhanVien USER = null;
    //Xóa thông tin đăng nhập khi người dùng yêu cầu đăng xuất
    public static void Logout(){
        shareHelper.USER=null;
    }
    //Kiểm tra đăng nhập hay chưa
    //@Retum Đăng nhập hay chưa
    public static boolean authenticated(){
        return shareHelper.USER!=null;
    }
}
