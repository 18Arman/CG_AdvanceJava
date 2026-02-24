package in.cg.Main;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import in.cg.service.*;
public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("in/cg/config/applicationContext.xml");
        LibraryService libraryService =
                context.getBean(LibraryService.class);
        BookService bookService =
                context.getBean(BookService.class);
        MemberService memberService =
                context.getBean(MemberService.class);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Register Member");
            System.out.println("2. Add Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Available Books");
            System.out.println("6. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter name:");
                    String name = sc.nextLine();
                    System.out.println("Enter email:");
                    String email = sc.nextLine();
                    memberService.registerMember(name, email);
                    break;
                case 2:
                    System.out.println("Enter title:");
                    String title = sc.nextLine();
                    System.out.println("Enter author:");
                    String author = sc.nextLine();
                    bookService.addBook(title, author);
                    break;
                case 3:
                    System.out.println("Enter memberId:");
                    int mId = sc.nextInt();
                    System.out.println("Enter bookId:");
                    int bId = sc.nextInt();
                    libraryService.issueBook(mId, bId);
                    break;
                case 4:
                    System.out.println("Enter memberId:");
                    mId = sc.nextInt();
                    System.out.println("Enter bookId:");
                    bId = sc.nextInt();
                    libraryService.returnBook(mId, bId);
                    break;
                case 5:
                    bookService.getAvailableBooks();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }
}