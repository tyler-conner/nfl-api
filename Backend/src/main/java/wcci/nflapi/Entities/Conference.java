package wcci.nflapi.Entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Conference {

	@Id
	@GeneratedValue
	private Long id;

	private String conferenceName;
	private String imgUrl;

	@OneToMany (mappedBy = "conference")
	private Collection <Division> divisions;

	protected Conference() {
	}

	public Conference(String name, String imgUrl) {
		this.conferenceName = name;
		this.imgUrl = imgUrl;
		this.divisions = new ArrayList<>();
	}

	public String getConferenceName() {
		return conferenceName;
	}

	public String getImgUrl() {
		return imgUrl;
	}
	
	public Long getId() {
		return id;
	}
	public Collection<Division> getDivisions() {
		return divisions;
	}
	public void addDivision(Division division) {
		this.divisions.add(division);
	}

	@Override
	public int hashCode()
		{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
		}

	@Override
	public boolean equals(Object obj)
		{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conference other = (Conference) obj;
		if (id == null)
			{
			if (other.id != null)
				return false;
			}
		else if (!id.equals(other.id))
			return false;
		return true;
		}

}
