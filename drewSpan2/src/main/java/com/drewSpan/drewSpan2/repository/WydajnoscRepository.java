package com.drewSpan.drewSpan2.repository;

import com.drewSpan.drewSpan2.model.Wydajnosc;
import com.drewSpan.drewSpan2.model.WydajnoscElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

@Repository
public interface WydajnoscRepository extends JpaRepository<Wydajnosc,Long> {


    // DROP ALL
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "drop table if exists xxx,wykonanie_normy,czas_calkowity,sumowanie,wydajnosc,wydajnosc_element", nativeQuery = true)

    void dropTempTables();

    // Kwerenda  xxx
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "create temporary table xxx as SELECT user.knt_nazwisko,ewidencja_elementy.e_id, ewidencja.user_id, ewidencja_elementy.data, ewidencja_elementy.id_indeksu, ewidencja_elementy.opt_id, index_op_elementy.op_tech_opt_id, If(ewidencja_elementy.opt_id=index_op_elementy.op_tech_opt_id,index_op_elementy.czas*index_op_elementy.wspk,0) AS Czas1, ewidencja_elementy.ilosc, ewidencja_elementy.czas, ewidencja.e_czas_pracy\n" +
            "FROM ewidencja INNER JOIN (index_op_elementy INNER JOIN ewidencja_elementy ON index_op_elementy.index_op_id_indeksu = ewidencja_elementy.id_indeksu) ON ewidencja.e_id = ewidencja_elementy.e_id\n" +
            "Inner join user on user.knt_id = ewidencja.user_id\n" +
            "GROUP BY user.knt_nazwisko,e_id, ewidencja.user_id, ewidencja_elementy.data, ewidencja_elementy.id_indeksu, ewidencja_elementy.opt_id, index_op_elementy.op_tech_opt_id, If(ewidencja_elementy.opt_id=index_op_elementy.op_tech_opt_id,index_op_elementy.czas*index_op_elementy.wspk,0), ewidencja_elementy.ilosc, ewidencja_elementy.czas, ewidencja.e_czas_pracy;\n", nativeQuery = true)
    void createXxx();

    // Lista xxx
    @Query(nativeQuery = true, value = "SELECT * from xxx")
    List<Object> listXxx();


    // Kwerenda  Wykonanie normy
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "create temporary table if not exists wykonanie_normy SELECT xxx.user_id, xxx.knt_nazwisko, xxx.data, xxx.id_indeksu, xxx.opt_id, xxx.Czas1, xxx.ilosc, (xxx.ilosc*xxx.Czas1)/60 AS cwn, xxx.e_czas_pracy, xxx.czas\n" +
            "FROM xxx\n" +
            "GROUP BY xxx.user_id, xxx.knt_nazwisko, xxx.data, xxx.id_indeksu, xxx.opt_id, xxx.Czas1, xxx.ilosc, (xxx.ilosc*xxx.Czas1)/60, xxx.e_czas_pracy, xxx.czas;\n", nativeQuery = true)
    void createWykonanieNormy();



    // Lista WykonanieNormy
    @Query(nativeQuery = true, value = "SELECT * from wykonanie_normy")
    List<Object> listWykonanieNormy();

    // Kwerenda  Czas calkowity
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "create temporary table czas_calkowity SELECT wykonanie_normy.user_id, wykonanie_normy.knt_nazwisko, wykonanie_normy.data, Sum(wykonanie_normy.CWN) AS SumaCWN, wykonanie_normy.e_czas_pracy, wykonanie_normy.Czas\n" +
            "FROM wykonanie_normy\n" +
            "GROUP BY wykonanie_normy.user_id, wykonanie_normy.knt_nazwisko, wykonanie_normy.data, wykonanie_normy.e_czas_pracy, wykonanie_normy.czas", nativeQuery = true)
    void createCzasCalkowity();

    // Lista WykonanieNormy
    @Query(nativeQuery = true, value = "SELECT * from czas_calkowity")
    List<Object> listCzasCalkowity();


    // Kwerenda  Wydajnosc
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "create temporary table wydajnosc as SELECT czas_calkowity.user_id, czas_calkowity.knt_nazwisko, czas_calkowity.data, sum(concat(format((czas_calkowity.SumaCWN/(czas_calkowity.e_czas_pracy-czas_calkowity.Czas - 30)) * 100,2),\"%\"))/count(czas_calkowity.data) AS wydajnosc\n" +
            "FROM czas_calkowity\n" +
            "GROUP BY czas_calkowity.user_id, czas_calkowity.knt_nazwisko, czas_calkowity.data, czas_calkowity.SumaCWN/czas_calkowity.e_czas_pracy-czas_calkowity.Czas-30", nativeQuery = true)
    void createWydajnosc();


    // Lista Wydajnosc
    @Query(nativeQuery = true, value = "SELECT * from wydajnosc;")
    List<Object> listWydajnosc();

    @Query("SELECT " +
            "    new com.drewSpan.drewSpan2.model.Wydajnosc(wydajnosc.user_id,wydajnosc.knt_nazwisko,wydajnosc.data,wydajnosc.wydajnosc) " +
            "FROM " +
            "    Wydajnosc ")
    List<Wydajnosc> findWydajnosc();


    @Query("SELECT " +
            "    new com.drewSpan.drewSpan2.model.Wydajnosc(wydajnosc.user_id,wydajnosc.knt_nazwisko,AVG(wydajnosc.wydajnosc)) " +
            "FROM " +
            "    Wydajnosc " +
            "where YEAR(wydajnosc.data) = ?1 AND MONTH(wydajnosc.data) = ?2 " +
            "GROUP BY wydajnosc.user_id, wydajnosc.knt_nazwisko, MONTH(wydajnosc.data)")
    List<Wydajnosc> findWydajnoscByDate(int year, int month);






    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "create temporary table if not exists wykonanie_normy\n" +
            "SELECT xxx.user_id, xxx.knt_nazwisko, xxx.data, xxx.id_indeksu, xxx.opt_id, xxx.Czas1, xxx.ilosc, (xxx.ilosc*xxx.Czas1)/60 AS cwn, xxx.e_czas_pracy, xxx.czas \n" +
            "FROM xxx WHERE xxx.opt_id = ?2 and xxx.id_indeksu = ?1\n" +
            "GROUP BY xxx.id_indeksu,xxx.user_id, xxx.knt_nazwisko, xxx.data, xxx.opt_id, xxx.Czas1, xxx.ilosc, (xxx.ilosc*xxx.Czas1)/60, xxx.e_czas_pracy, xxx.czas;", nativeQuery = true)
    void createWykonanieNormySearchIndex(int id_indeksu,int id_operacji);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "create temporary table czas_calkowity\n" +
            "SELECT wykonanie_normy.opt_id, wykonanie_normy.id_indeksu, user_id, wykonanie_normy.knt_nazwisko, wykonanie_normy.data, Sum(wykonanie_normy.CWN) AS SumaCWN, wykonanie_normy.e_czas_pracy, wykonanie_normy.Czas\n" +
            "FROM wykonanie_normy\n" +
            "GROUP BY wykonanie_normy.user_id, wykonanie_normy.knt_nazwisko, wykonanie_normy.data, wykonanie_normy.e_czas_pracy, wykonanie_normy.czas", nativeQuery = true)
    void createCzasCalkowitySearchIndex();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "create temporary table if not exists wydajnosc as SELECT czas_calkowity.opt_id, czas_calkowity.id_indeksu, user_id, czas_calkowity.knt_nazwisko, czas_calkowity.data, sum(format((czas_calkowity.SumaCWN/(czas_calkowity.e_czas_pracy-czas_calkowity.Czas - 30)) * 100,2))/count(czas_calkowity.data) AS wydajnosc \n" +
            "FROM czas_calkowity GROUP BY czas_calkowity.user_id, czas_calkowity.knt_nazwisko, czas_calkowity.data, czas_calkowity.SumaCWN/czas_calkowity.e_czas_pracy-czas_calkowity.Czas-30", nativeQuery = true)
    void createSumowanieSearchIndex();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "create temporary table if not exists wydajnosc_element\n" +
            "select\n" +
            "wydajnosc.opt_id, wydajnosc.id_indeksu, sum(wydajnosc.wydajnosc)/count(wydajnosc.wydajnosc) as wydajnosc from wydajnosc\n" +
            "group by wydajnosc.opt_id", nativeQuery = true)
    void createWydajnoscSearchIndex();



    // Lista Wydajnosc
    @Query(nativeQuery = true, value = "SELECT opt_id,id_indeksu,wydajnosc from wydajnosc_element;")
    List<Object> listWydajnoscSearchIndex();

    @Query("SELECT " +
            "    new com.drewSpan.drewSpan2.model.WydajnoscElement(opt_id,id_indeksu,wydajnosc) " +
            "FROM " +
            "    WydajnoscElement")
    List<WydajnoscElement> findWydajnoscSearchIndex();

    /*@Query(nativeQuery = true, value ="Select * from wydajnosc")
    ResultSet findWydajnoscSearchIndex();*/


















}
