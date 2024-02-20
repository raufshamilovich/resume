package dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDAO {

// kim bu classi extend etse connect() metodunu elde etmish olacag yeni daha onlar ucun ashagida
    //herdefe connect lazim olanda birde uzun uzadi bunlari yazmasi lazim olmayacag
    public Connection connect()throws Exception{
        String url = "jdbc:mysql://localhost:33066/resume";
        String kullaniciAdi = "root";
        String sifre = "3457707rauffuar";
        Connection c= DriverManager.getConnection(url,kullaniciAdi,sifre);
        return c;

    }
}
