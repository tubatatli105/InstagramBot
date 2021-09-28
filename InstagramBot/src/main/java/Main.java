import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input your username : ");
        String username = scanner.nextLine();
        System.out.println("Please input your password : ");
        String password = scanner.nextLine();
        System.out.println("Please input target profile : ");
        String targetProfile = scanner.nextLine();

        App app = new App();
        app.loginWith(username,password);
        app.navigateToProfile(targetProfile);
        app.clickFirstPost();
        app.likeAllPost();
    }
}
