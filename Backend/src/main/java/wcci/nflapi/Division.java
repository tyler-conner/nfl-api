package wcci.nflapi;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Division {
	
	@Id
	@GeneratedValue
	private Long id;
	private String imgUrl;
	
	private String divisionName;
	
	@ManyToOne
	private Conference conference;
	
	@OneToMany (mappedBy = "division")
	private Collection<Team> teams;

	
	protected Division() {
		
	}
	
	public Division(String divisionName, String imgUrl) {
		this.divisionName = divisionName;
		this.imgUrl = imgUrl;
	}

	public Long getId() {
		return id;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public Conference getConference() {
		return conference;
	}

	public Collection<Team> getTeams() {
		return teams;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Division other = (Division) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
