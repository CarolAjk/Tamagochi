import org.junit.jupiter.api.Test;
import com.utadeo.tamagochi.database.entities.Tamagochi;
import com.utadeo.tamagochi.database.daos.TamagochiDAO;
import com.utadeo.tamagochi.database.HibernateUtil;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TamagochiDAOTest {

    @Test
    void insertTest() {

        try {
            Tamagochi tamagochi = new Tamagochi();
            tamagochi.setBaño(1);
            tamagochi.setEnergia(2);
            tamagochi.setHambre(3);
            tamagochi.setSueño(4);
            tamagochi.setNombre("tamagochi");

            TamagochiDAO tamagochiDAO = new TamagochiDAO();
            tamagochiDAO.insert(tamagochi);

            assertTrue(true);
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
            assertTrue(false);
        }

    }
}