import Html from "../Html/Html";
import headerImg from "../../../images/NFL_logo_png.png";
import Api from "../Api/Api";

export default () => new Components();

class Components {
  getAppContext() {
    return Html().select("#app");
  }
  getWrapperDiv() {
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

  // renderPageSingle(data, endpoint) {
  //   const typeOfObject = endpoint.split("/")[1];
  //   if (typeOfObject === "conferences") {
  //     this.renderPageConference(data);
  //   }
  //   if (typeOfObject === "divisions") {
  //     this.renderPageDivision(data);
  //   }
  //   if (typeOfObject === "teams") {
  //     this.renderPageTeam(data);
  //   }
  // }

  renderPageHome() {
    const app = this.getAppContext();
    const wrapper = this.getWrapperDiv();
    const mainHeader = this.renderMainHeader();
    // const mainContent = this.renderMainContent();
    const mainFooter = this.renderMainFooter();
    wrapper.addChild(mainHeader);
    // wrapper.addChild(mainContent);
    wrapper.addChild(mainFooter);
    app.addChild(wrapper);
  }
}
