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

		Conference afc = new Conference("AFC",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/7/7a/American_Football_Conference_logo.svg/1200px-American_Football_Conference_logo.svg.png");
		conferenceRepo.save(afc);
		Conference nfc = new Conference("NFC",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/National_Football_Conference_logo.svg/1200px-National_Football_Conference_logo.svg.png");
		conferenceRepo.save(nfc);

		Division afcEast = new Division("AFC East",
				"http://okdeploy.onyxlight.net/wp-content/uploads/maxresdefault1.jpg");
		divisionRepo.save(afcEast);
		Division afcWest = new Division("AFC West", "https://i.ytimg.com/vi/eakmqXOh7eI/maxresdefault.jpg");
		divisionRepo.save(afcWest);
		Division afcSouth = new Division("AFC South",
				"https://www.outkickthecoverage.com/wp-content/uploads/afc_south-1280x6401.jpg");
		divisionRepo.save(afcSouth);
		Division afcNorth = new Division("AFC North",
				"https://chumley.barstoolsports.com/wp-content/uploads/2019/03/12/21.jpg");
		divisionRepo.save(afcNorth);

		Division nfcEast = new Division("NFC East",
				"https://www.dmvsportsnetwork.com/wp-content/uploads/2019/05/NFC-East.jpg");
		divisionRepo.save(nfcEast);
		Division nfcWest = new Division("NFC West",
				"http://oregonsportsnews.com/wp-content/uploads/2018/10/NFCWest.jpg");
		divisionRepo.save(nfcWest);
		Division nfcSouth = new Division("NFC South",
				"http://okdeploy.onyxlight.net/wp-content/uploads/NFC_South1.jpg");
		divisionRepo.save(nfcSouth);
		Division nfcNorth = new Division("NFC North",
				"http://okdeploy.onyxlight.net/wp-content/uploads/stu_roto_nfcnorthteamneeds_1804131.jpg");
		divisionRepo.save(nfcNorth);

		Team newEngland = new Team("New England", "Patriots",
				"https://upload.wikimedia.org/wikipedia/en/thumb/b/b9/New_England_Patriots_logo.svg/200px-New_England_Patriots_logo.svg.png",
				"Bill Belichick", "0-0");
		teamRepo.save(newEngland);
		Team miami = new Team("Miami", "Dolphins",
				"https://upload.wikimedia.org/wikipedia/en/thumb/3/37/Miami_Dolphins_logo.svg/200px-Miami_Dolphins_logo.svg.png",
				"Brian Flores", "0-0");
		teamRepo.save(miami);
		Team buffalo = new Team("Buffalo", "Bills",
				"https://upload.wikimedia.org/wikipedia/en/thumb/7/77/Buffalo_Bills_logo.svg/200px-Buffalo_Bills_logo.svg.png",
				"Sean McDermott", "0-0");
		teamRepo.save(buffalo);
		Team newYorkJets = new Team("New York", "Jets",
				"https://upload.wikimedia.org/wikipedia/en/thumb/6/6b/New_York_Jets_logo.svg/200px-New_York_Jets_logo.svg.png",
				"Adam Gase", "0-0");
		teamRepo.save(newYorkJets);

		Team denver = new Team("Denver", "Broncos",
				"https://upload.wikimedia.org/wikipedia/en/thumb/4/44/Denver_Broncos_logo.svg/200px-Denver_Broncos_logo.svg.png",
				"Vic Fangio", "0-0");
		teamRepo.save(denver);
		Team lasVegas = new Team("Las Vegas", "Raiders",
				"https://upload.wikimedia.org/wikipedia/en/thumb/e/ec/Oakland_Raiders_logo.svg/200px-Oakland_Raiders_logo.svg.png",
				"Jon Gruden", "0-0");
		teamRepo.save(lasVegas);
		Team losAngelesChargers = new Team("Los Angeles", "Chargers",
				"https://upload.wikimedia.org/wikipedia/en/thumb/7/72/NFL_Chargers_logo.svg/200px-NFL_Chargers_logo.svg.png",
				"Anthony Lynn", "0-0");
		teamRepo.save(losAngelesChargers);
		Team kansasCity = new Team("Kansas City", "Chiefs",
				"https://upload.wikimedia.org/wikipedia/en/thumb/e/e1/Kansas_City_Chiefs_logo.svg/200px-Kansas_City_Chiefs_logo.svg.png",
				"Andy Reid", "0-0");
		teamRepo.save(kansasCity);

		Team houston = new Team("Houston", "Texans",
				"https://upload.wikimedia.org/wikipedia/en/thumb/2/28/Houston_Texans_logo.svg/200px-Houston_Texans_logo.svg.png",
				"Bill O'Brien", "0-0");
		teamRepo.save(houston);
		Team indianapolis = new Team("Indianapolis", "Colts",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/0/00/Indianapolis_Colts_logo.svg/200px-Indianapolis_Colts_logo.svg.png",
				"Frank Reich", "0-0");
		teamRepo.save(indianapolis);
		Team tennessee = new Team("Tennessee", "Titans",
				"https://upload.wikimedia.org/wikipedia/en/thumb/c/c1/Tennessee_Titans_logo.svg/200px-Tennessee_Titans_logo.svg.png",
				"Mike Vrabel", "0-0");
		teamRepo.save(tennessee);
		Team jacksonville = new Team("Jacksonville", "Jaguars",
				"https://upload.wikimedia.org/wikipedia/en/thumb/7/74/Jacksonville_Jaguars_logo.svg/200px-Jacksonville_Jaguars_logo.svg.png",
				"Doug Marrone", "0-0");
		teamRepo.save(jacksonville);

		Team cleveland = new Team("Cleveland", "Browns",
				"https://upload.wikimedia.org/wikipedia/en/thumb/d/d9/Cleveland_Browns_logo.svg/200px-Cleveland_Browns_logo.svg.png",
				"Freddie Kitchens", "0-0");
		teamRepo.save(cleveland);
		Team cincinnati = new Team("Cincinnati", "Bengals",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/8/81/Cincinnati_Bengals_logo.svg/200px-Cincinnati_Bengals_logo.svg.png",
				"Zac Taylor", "0-0");
		teamRepo.save(cincinnati);
		Team pittsburgh = new Team("Pittsburgh", "Steelers",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/d/de/Pittsburgh_Steelers_logo.svg/200px-Pittsburgh_Steelers_logo.svg.png",
				"Mike Tomlin", "0-0");
		teamRepo.save(pittsburgh);
		Team baltimore = new Team("Baltimore", "Ravens",
				"https://upload.wikimedia.org/wikipedia/en/thumb/1/16/Baltimore_Ravens_logo.svg/200px-Baltimore_Ravens_logo.svg.png",
				"John Harbaugh", "0-0");
		teamRepo.save(baltimore);

		Team philadelphia = new Team("Philadelphia", "Eagles",
				"https://upload.wikimedia.org/wikipedia/en/thumb/8/8e/Philadelphia_Eagles_logo.svg/200px-Philadelphia_Eagles_logo.svg.png",
				"Doug Pederson", "0-0");
		teamRepo.save(philadelphia);
		Team newYorkGiants = new Team("New York", "Giants",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/6/60/New_York_Giants_logo.svg/200px-New_York_Giants_logo.svg.png",
				"Pat Shurmur", "0-0");
		teamRepo.save(newYorkGiants);
		Team dallas = new Team("Dallas", "Cowboys",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Dallas_Cowboys.svg/200px-Dallas_Cowboys.svg.png",
				"Jason Garrett", "0-0");
		teamRepo.save(dallas);
		Team washington = new Team("Washington", "Redskins",
				"https://upload.wikimedia.org/wikipedia/en/thumb/6/63/Washington_Redskins_logo.svg/200px-Washington_Redskins_logo.svg.png",
				"Jay Gruden", "0-0");
		teamRepo.save(washington);

		Team losAngelesRams = new Team("Los Angeles", "Rams",
				"https://upload.wikimedia.org/wikipedia/en/thumb/8/8a/Los_Angeles_Rams_logo.svg/200px-Los_Angeles_Rams_logo.svg.png",
				"Sean McVay", "0-0");
		teamRepo.save(losAngelesRams);
		Team sanFransisco = new Team("San Fransisco", "49ers",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/San_Francisco_49ers_logo.svg/200px-San_Francisco_49ers_logo.svg.png",
				"Kyle Shanahan", "0-0");
		teamRepo.save(sanFransisco);
		Team arizona = new Team("Arizona", "Cardinals",
				"https://upload.wikimedia.org/wikipedia/en/thumb/7/72/Arizona_Cardinals_logo.svg/200px-Arizona_Cardinals_logo.svg.png",
				"Kliff Kingsbury", "0-0");
		teamRepo.save(arizona);
		Team seattle = new Team("Seattle", "Seahawks",
				"https://upload.wikimedia.org/wikipedia/en/thumb/8/8e/Seattle_Seahawks_logo.svg/200px-Seattle_Seahawks_logo.svg.png",
				"Pete Carrol", "0-0");
		teamRepo.save(seattle);

		Team atlanta = new Team("Atlanta", "Falcons",
				"https://upload.wikimedia.org/wikipedia/en/thumb/c/c5/Atlanta_Falcons_logo.svg/200px-Atlanta_Falcons_logo.svg.png",
				"Dan Quinn", "0-0");
		teamRepo.save(atlanta);
		Team carolina = new Team("Carolina", "Panthers",
				"https://upload.wikimedia.org/wikipedia/en/thumb/1/1c/Carolina_Panthers_logo.svg/200px-Carolina_Panthers_logo.svg.png",
				"Ron Rivera", "0-0");
		teamRepo.save(carolina);
		Team newOrleans = new Team("New Orleans", "Saints",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/New_Orleans_Saints_logo.svg/197px-New_Orleans_Saints_logo.svg.png",
				"Sean Payton", "0-0");
		teamRepo.save(newOrleans);
		Team tampaBay = new Team("Tampa Bay", "Buccaneers",
				"https://upload.wikimedia.org/wikipedia/en/thumb/a/a2/Tampa_Bay_Buccaneers_logo.svg/200px-Tampa_Bay_Buccaneers_logo.svg.png",
				"Bruce Arians", "0-0");
		teamRepo.save(tampaBay);

		Team minnesota = new Team("Minnesota", "Vikings",
				"https://upload.wikimedia.org/wikipedia/en/thumb/4/48/Minnesota_Vikings_logo.svg/195px-Minnesota_Vikings_logo.svg.png",
				"Mike Zimmer", "0-0");
		teamRepo.save(minnesota);
		Team greenBay = new Team("Green Bay", "Packers",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Green_Bay_Packers_logo.svg/200px-Green_Bay_Packers_logo.svg.png",
				"Matt LaFleur", "0-0");
		teamRepo.save(greenBay);
		Team chicago = new Team("Chicago", "Bears",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Chicago_Bears_logo.svg/200px-Chicago_Bears_logo.svg.png",
				"Matt Nagy", "0-0");
		teamRepo.save(chicago);
		Team detroit = new Team("Detroit", "Lions",
				"https://upload.wikimedia.org/wikipedia/en/thumb/7/71/Detroit_Lions_logo.svg/200px-Detroit_Lions_logo.svg.png",
				"Matt Patricia", "0-0");
		teamRepo.save(detroit);

		afc.addDivision(afcEast);
		afc.addDivision(afcWest);
		afc.addDivision(afcSouth);
		afc.addDivision(afcNorth);

		afcEast.addTeam(newEngland);
		afcEast.addTeam(buffalo);
		afcEast.addTeam(miami);
		afcEast.addTeam(newYorkJets);

		afcWest.addTeam(denver);
		afcWest.addTeam(losAngelesChargers);
		afcWest.addTeam(lasVegas);
		afcWest.addTeam(kansasCity);

		afcSouth.addTeam(houston);
		afcSouth.addTeam(indianapolis);
		afcSouth.addTeam(tennessee);
		afcSouth.addTeam(jacksonville);

		afcNorth.addTeam(cleveland);
		afcNorth.addTeam(cincinnati);
		afcNorth.addTeam(pittsburgh);
		afcNorth.addTeam(baltimore);

		nfc.addDivision(nfcEast);
		nfc.addDivision(nfcWest);
		nfc.addDivision(nfcSouth);
		nfc.addDivision(nfcNorth);

		nfcEast.addTeam(philadelphia);
		nfcEast.addTeam(newYorkGiants);
		nfcEast.addTeam(dallas);
		nfcEast.addTeam(washington);

		nfcWest.addTeam(losAngelesRams);
		nfcWest.addTeam(arizona);
		nfcWest.addTeam(sanFransisco);
		nfcWest.addTeam(seattle);

		nfcSouth.addTeam(atlanta);
		nfcSouth.addTeam(newOrleans);
		nfcSouth.addTeam(tampaBay);
		nfcSouth.addTeam(carolina);

		nfcNorth.addTeam(minnesota);
		nfcNorth.addTeam(greenBay);
		nfcNorth.addTeam(detroit);
		nfcNorth.addTeam(chicago);
	}

}
