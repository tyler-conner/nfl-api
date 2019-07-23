package wcci.nflapi.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Team {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String imgUrl;
	private String coachName;
	private String mascot;	
	private String record;
	
	
	@ManyToOne
	private Division division;

	protected Team() {
		
	}
	
	public Team(String name, String mascot, String imgUrl, String coachName,  String record) {
		this.name = name;
		this.imgUrl = imgUrl;
		this.coachName = coachName;
		this.mascot = mascot;
		this.record = record;
		
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getCoachName() {
		return coachName;
	}

	public String getMascot() {
		return mascot;
	}

	public String getRecord() {
		return record;
	}

	public Division getDivision() {
		return division;
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
		Team other = (Team) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
