package bartender.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cocktail")
public class Cocktail {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "customer_no")
	String customerNo;

	@Column(name = "drink_type")
	String drinkType;

	@Column(name = "status")
	String status;
	 
	 
	 /*CREATE TABLE `cocktail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_no` varchar(100) NOT NULL,
   `drink_type` varchar(255) NOT NULL,
    `status` varchar(80) NOT NULL,
    PRIMARY KEY (`id`)
) */
}
