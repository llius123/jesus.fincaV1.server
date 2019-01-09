package fincaV1.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "recibo_vecino")
@SecondaryTables({
	@SecondaryTable(name = "recibo", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "id") }),
	@SecondaryTable(name = "vecino", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "id") })})
public class ReciboVecinoBean {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		@NotNull
		private int id;
		
		@ManyToOne
		@JoinColumn(name = "id_recibo")
		@NotNull
		private ReciboBean recibo;
		
		@ManyToOne
		@JoinColumn(name = "id_vecino")
		@NotNull
		private VecinoBean vecino;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public ReciboBean getRecibo() {
			return recibo;
		}

		public void setRecibo(ReciboBean recibo) {
			this.recibo = recibo;
		}

		public VecinoBean getVecino() {
			return vecino;
		}

		public void setVecino(VecinoBean vecino) {
			this.vecino = vecino;
		}

		@Override
		public String toString() {
			return "ReciboVecinoBean [id=" + id + ", recibo=" + recibo + ", vecino=" + vecino + "]";
		}
		
		
}
