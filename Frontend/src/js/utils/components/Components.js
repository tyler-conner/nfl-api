import Html from "../Html/Html";
import headerImg from "../../../images/NFL_logo_png.png";
import Api from "../Api/Api";

export default () => new Components();

class Components {
  getAppContext() {
    return Html().select("#app");
  }
  renderWrapperDiv() {
    return Html()
      .create("div")
      .addClass("wrapper");
  }
  renderMainHeader() {
    const mainHeader = Html()
      .create("header")
      .addClass("main-header");
    const mainHeaderImg = Html()
      .create("img")
      .addClass("main-header__image")
      .addAttribute("src", headerImg);
    const mainHeaderTitle = Html()
      .create("h1")
      .addClass("main-header__title")
      .text("The Ultimate NFL Database");
    const nav = this.renderMainNav();
    mainHeader.addChild(mainHeaderImg);
    mainHeader.addChild(mainHeaderTitle);
    mainHeader.addChild(nav);
    return mainHeader;
  }
  renderMainNav() {
    const nav = Html().create("nav");
    const navList = Html()
      .create("ul")
      .addClass("nav__list");
    const navListItemOne = Html()
      .create("li")
      .addClass("nav__list-item")
      .addChild(
        Html()
          .create("a")
          .addAttribute("href", "")
          .text("Conferences")
          .click(event => {
            event.preventDefault();
            this.renderPageConferences();
          })
      );
    const navListItemTwo = Html()
      .create("li")
      .addClass("nav__list-item")
      .addChild(
        Html()
          .create("a")
          .addAttribute("href", "")
          .text("Divisions")
          .click(event => {
            event.preventDefault();
            this.renderPageDivisions();
          })
      );
    const navListItemThree = Html()
      .create("li")
      .addClass("nav__list-item")
      .addChild(
        Html()
          .create("a")
          .addAttribute("href", "")
          .text("Teams")
          .click(event => {
            event.preventDefault();
            this.renderPageTeams();
          })
      );
    navList.addChild(navListItemOne);
    navList.addChild(navListItemTwo);
    navList.addChild(navListItemThree);
    nav.addChild(navList);

    return nav;
  }
  renderMainFooter() {
    const mainFooter = Html()
      .create("footer")
      .addClass("main-footer");
    const mainFooterCopy = Html()
      .create("small")
      .addClass("main-footer__copy")
      .addHtml("&copy; 2019 NFL API");
    mainFooter.addChild(mainFooterCopy);
    return mainFooter;
  }
  renderContentBlock(requestedData) {
    const contentBlock = Html()
      .create("section")
      .addClass("content-block");
    const contentBlockTitle = Html()
      .create("h2")
      .addClass("content-block__title")
      .text(requestedData);
    const contentBlockList = Html()
      .create("ul")
      .addClass("content-block__list");
    Api().getRequest(
      `http://localhost:8080/api/${requestedData}`,
      responseCollection => {
        responseCollection.forEach(item => {
          let elementName;
          if (item.divisionName) {
            elementName = item.divisionName;
          } else if (item.conferenceName) {
            elementName = item.conferenceName;
          } else {
            elementName = item.teamName;
          }
          const contentBlockListItem = Html()
            .create("li")
            .addClass("content-block__list-item")
            .addChild(
              Html()
                .create("a")
                .addAttribute("href", `/${requestedData}/${item.id}`)
                .text(elementName)
                .click(event => {
                  event.preventDefault();

                  const endpoint = event.target.getAttribute("href");
                  Api().getRequest(
                    `http://localhost:8080/api${endpoint}`,
                    data => {
                      this.renderPageSingle(data, endpoint);
                    }
                  );
                })
            );
          contentBlockList.addChild(contentBlockListItem);
        });
      }
    );
    contentBlock.addChild(contentBlockTitle);
    contentBlock.addChild(contentBlockList);
    return contentBlock;
  }
  renderMainContent(requestedData) {
    const mainContent = Html()
      .create("main")
      .addClass("main-content");
    const containerDiv = Html()
      .create("div")
      .addClass("container");
    const contentBlock = this.renderContentBlock(requestedData);
    containerDiv.addChild(contentBlock);
    mainContent.addChild(containerDiv);
    return mainContent;
  }

  renderPageConference(data) {
    const currentMainContentContainerContentBlock = this.renderWrapperDiv()
      .select(".main-content")
      .select(".container")
      .select(".content-block");
    const conferenceEntry = Html()
      .create("div")
      .addClass("conferenceEntry");
    const conferenceName = Html()
      .create("h3")
      .addClass("content-block__title")
      .text(data.conferenceName);
    const conferenceImage = Html()
      .create("img")
      .addClass("conferenceEntry__image")
      .addAttribute("src", data.imgUrl);
    const conferenceDivisions = Html().create("ul");
    data.divisions.forEach(division => {
      const divisionElement = Html()
        .create("li")
        .addChild(
          Html()
            // .addClass("divisionEntry__image")
            // .addAttribute("src", data.imgUrl)
            .create("a")
            .addAttribute("href", `/divisions/${division.id}`)
            .text(division.divisionName)
            .click(event => {
              event.preventDefault();

              const endpoint = event.target.getAttribute("href");
              Api().getRequest(`http://localhost:8080/api${endpoint}`, data => {
                this.renderPageSingle(data, endpoint);
              });
            })
        );

      conferenceDivisions.addChild(divisionElement);
    });
    conferenceEntry.addChild(conferenceImage);
    conferenceEntry.addChild(conferenceName);
    conferenceEntry.addChild(conferenceDivisions);
    currentMainContentContainerContentBlock.replace(conferenceEntry);
  }

  renderPageDivision(data) {
    const currentMainContentContainerContentBlock = this.renderWrapperDiv()
      .select(".main-content")
      .select(".container")
      .select(".content-block");
    const divisionEntry = Html()
      .create("div")
      .addClass("divisionEntry");
    const divisionName = Html()
      .create("h3")
      .addClass("content-block__title")
      .text(data.divisionName);
    const teamListTitle = Html()
      .create("h1")
      .addClass("titles")
      .text("TEAMS");
    const divisionTeams = Html().create("ul");
    data.teams.forEach(team => {
      const teamElement = Html()
        .create("img")
        .addClass("conferenceEntry__image")
        .addAttribute("src", data.imgUrl)
        .create("a")
        .addAttribute("href", `/teams/${team.id}`)
        .click(event => {
          event.preventDefault();

          const endpoint = event.target.getAttribute("href");
          Api().getRequest(`http://localhost:8080/api${endpoint}`, data => {
            this.renderPageSingle(data, endpoint);
          });
        });
      divisionTeams.addChild(teamElement);
    });
    divisionEntry.addChild(divisionName);
    divisionEntry.addChild(teamListTitle);
    currentMainContentContainerContentBlock.replace(divisionEntry);
  }

  renderPageTeam(data) {
    const currentMainContentContainerContentBlock = this.renderWrapperDiv()
      .select(".main-content")
      .select(".container")
      .select(".content-block");
    const teamEntry = Html()
      .create("div")
      .addClass("teamEntry");
    const teamName = Html()
      .create("h3")
      .addClass("content-block__title")
      .text(data.teamName);
    const mascot = Html()
      .create("h3")
      .addClass("content-block__title")
      .text(data.mascot);
    const teamImage = Html()
      .create("img")
      .addClass("teamEntry__image")
      .addAttribute("src", data.imgUrl);
    const coachName = Html()
      .create("h3")
      .text(`COACH: ${data.coachName}`);
    const record = Html()
      .create("h3")
      .text(`RECORD: ${data.record}`);

    teamEntry.addChild(teamName);
    teamEntry.addChild(mascot);
    teamEntry.addChild(teamImage);
    teamEntry.addChild(coachName);
    teamEntry.addChild(record);
    currentMainContentContainerContentBlock.replace(teamEntry);
  }

  renderPageSingle(data, endpoint) {
    const typeOfObject = endpoint.split("/")[1];
    if (typeOfObject === "conferences") {
      this.renderPageConference(data);
    }
    if (typeOfObject === "divisions") {
      this.renderPageDivision(data);
    }
    if (typeOfObject === "teams") {
      this.renderPageTeam(data);
    }
  }

  renderPageHome() {
    const app = this.getAppContext();
    const wrapper = this.renderWrapperDiv();
    const mainHeader = this.renderMainHeader();
    const mainContent = this.renderMainContent("conferences");
    const mainFooter = this.renderMainFooter();
    wrapper.addChild(mainHeader);
    wrapper.addChild(mainContent);
    wrapper.addChild(mainFooter);
    app.addChild(wrapper);
  }
}
