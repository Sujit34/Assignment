package repositories;

import domain.CD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CDRepository extends JpaRepository<CD, Long> {
    List<CD> findByArtistAndPriceLessThan(String artist, double price);
    List<CD> findByArtist(@Param("artist") String artist);
    @Query("select cd from CD cd where cd.artist= :artist and cd.price > :price")
    List<CD> findAllCDsFromArtistAndPriceBiggerThan(@Param("artist")String artist, @Param("price")double price);

    @Query(value = "select * from cd inner join product on cd.id=product.id where artist = :artist",nativeQuery = true)
    List<CD> findByCertainArtist(@Param("artist")String artist);
}
