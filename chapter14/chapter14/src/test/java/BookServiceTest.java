import com.my.domain.Book;
import com.my.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by guodi on 2024/6/1 上午11:39
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:application-service.xml",
        "classpath:application-dao.xml"
})
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void findBookById(){
        Book book = bookService.findBookById(1);

        System.out.println(book.getAuthor());
    }
}
