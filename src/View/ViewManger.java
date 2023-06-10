
package View;

import java.io.IOException;


public class ViewManger {

    public static Rigster RigsterPage;
    public static LoginPatient LoginPage;
    public static loginAdmin loginAdmin;
    public static AdminDashboard AdminDashboard;
    public static PaitentDashboard PaitentDashboard;

    private ViewManger() {
    }

    public static void openRegisterPage() throws IOException {
        if (RigsterPage == null) {
            RigsterPage = new Rigster();
            RigsterPage.show();
        } else {
            RigsterPage.show();
        }

    }

    public static void closeRegisterPage() {
        if (RigsterPage != null) {
            RigsterPage.close();
        }
    }

    public static void openLoginPage() throws IOException {
        if (LoginPage == null) {
            LoginPage = new LoginPatient();
            LoginPage.show();
        } else {
            LoginPage.show();
        }

    }

    public static void closeLoginPage() {
        if (LoginPage != null) {
            LoginPage.close();
        }
    }

    public static void openloginAdmin() throws IOException {
        if (loginAdmin == null) {
            loginAdmin = new loginAdmin();
            loginAdmin.show();
        } else {
            loginAdmin.show();
        }

    }

    public static void closeloginAdmin() {
        if (loginAdmin != null) {
            loginAdmin.close();
        }
    }

    public static void openAdminDashboard() throws IOException {
        if (AdminDashboard == null) {
            AdminDashboard = new AdminDashboard();
            AdminDashboard.show();
        } else {
            AdminDashboard.show();
        }

    }

    public static void closeAdminDashboard() {
        if (AdminDashboard != null) {
            AdminDashboard.close();
        }
    }
    
 public static void openPaitentDashboard() throws IOException {
        if (PaitentDashboard == null) {
            PaitentDashboard = new PaitentDashboard();
            PaitentDashboard.show();
        } else {
            PaitentDashboard.show();
        }

    }

    public static void closePaitentDashboard() {
        if (PaitentDashboard != null) {
            PaitentDashboard.close();
        }
    }
}
