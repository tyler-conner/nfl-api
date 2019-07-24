package wcci.nflapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import wcci.nflapi.Entities.Conference;
import wcci.nflapi.Entities.Division;
import wcci.nflapi.Entities.Team;
import wcci.nflapi.Repositories.ConferenceRepository;
import wcci.nflapi.Repositories.DivisionRepository;
import wcci.nflapi.Repositories.TeamRepository;

@Component
public class Initializer implements CommandLineRunner {
	
	@Autowired
	ConferenceRepository conferenceRepo;
	
	@Autowired
	DivisionRepository divisionRepo;
	
	@Autowired
	TeamRepository teamRepo;
	
	@Override
	public void run(String... args) throws Exception {
	
	Conference afc = new Conference("AFC", "imageURL");
	conferenceRepo.save(afc);
	Conference nfc = new Conference("NFC", "imageURL");
	conferenceRepo.save(nfc);
	
	Division afcEast = new Division("AFC East", "imageURL");
	divisionRepo.save(afcEast);
	Division afcWest = new Division("AFC West", "imageURL");
	divisionRepo.save(afcWest);
	Division afcSouth = new Division("AFC South", "imageURL");
	divisionRepo.save(afcSouth);
	Division afcNorth = new Division("AFC North", "imageURL");
	divisionRepo.save(afcNorth);
	
	Division nfcEast = new Division("NFC East", "imageURL");
	divisionRepo.save(nfcEast);
	Division nfcWest = new Division("NFC West", "imageURL");
	divisionRepo.save(nfcWest);
	Division nfcSouth = new Division("NFC South", "imageURL");
	divisionRepo.save(nfcSouth);
	Division nfcNorth = new Division("NFC North", "imageURL");
	divisionRepo.save(nfcNorth);
	
	Team newEngland = new Team("New England","Patriots", "imgURl", "Bill Belichick", "0-0" );
	teamRepo.save(newEngland);
	Team denver = new Team("Denver","Broncos", "imgURl", "Vic Fangio", "0-0" );
	teamRepo.save(denver);
	Team houston = new Team("Houston","Texans", "imgURl", "Bill O'Brien", "0-0" );
	teamRepo.save(houston);
	Team cleveland = new Team("Cleveland","Browns", "imgURl", "Freddie Kitchens", "0-0" );
	teamRepo.save(cleveland);
	
	Team philadelphia = new Team("Philadelphia","Eagles", "imgURl", "Doug Pederson", "0-0" );
	teamRepo.save(philadelphia);
	Team losAngeles = new Team("Los Angeles","Rams", "imgURl", "Sean McVay", "0-0" );
	teamRepo.save(losAngeles);
	Team atlanta = new Team("Atlanta", "Falcons", "imgURl", "Dan Quinn", "0-0" );
	teamRepo.save(atlanta);
	Team minnesota = new Team("Minnesota","Vikings", "imgURl", "Mike Zimmer", "0-0" );
	teamRepo.save(minnesota);
	
	afc.addDivision(afcEast);
	afc.addDivision(afcWest);
	afc.addDivision(afcSouth);
	afc.addDivision(afcNorth);
	afcEast.addTeam(newEngland);
	afcWest.addTeam(denver);
	afcSouth.addTeam(houston);
	afcNorth.addTeam(cleveland);
	
	nfc.addDivision(nfcEast);
	nfc.addDivision(nfcWest);
	nfc.addDivision(nfcSouth);
	nfc.addDivision(nfcNorth);
	nfcEast.addTeam(philadelphia);
	nfcWest.addTeam(losAngeles);
	nfcSouth.addTeam(atlanta);
	nfcNorth.addTeam(minnesota);
	}

}
