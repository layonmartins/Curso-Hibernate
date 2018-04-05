package curso.hibernate.heranca;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue(value = "duas_rodas")
public class VeiculoDuasRodas extends VeiculoHeranca{

	private Integer cilindras;

	public Integer getCilindras() {
		return cilindras;
	}

	public void setCilindras(Integer cilindras) {
		this.cilindras = cilindras;
	}
}
