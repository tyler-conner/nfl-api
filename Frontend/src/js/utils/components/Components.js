import Html from "../Html/Html";
import headerImg from "../../../images/NFL_logo_png.png";
import Api from "../api/Api";

export default () => new Components();

class Components {
  getAppContext() {
    return Html().select("#app");
  }
  renderWrapperDiv() {
    return Html()
      .create("div")
      .addChild("wrapper");
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
          .text("Conferences")
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
          .text("Conferences")
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
}
