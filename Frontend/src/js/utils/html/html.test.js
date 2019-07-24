import html from "./html.js";

describe("html", () => {
  describe("create", () => {
    test("should be an 'object'", () => {
      expect(typeof Html().create("div")).toBe("object");
    });
  });
  describe("addAttribute", () => {
    test("should add attribute to element", () => {
      const underTest = html().create("a");
      underTest.addAttribute("href", "test.com");

      expect(underTest.render().getAttribute("href", "test.com")).toBeTruthy();
    });
  });
  describe("addClass", () => {
    test("should add a class to an element", () => {
      const underTest = html().create("h2");
      underTest.addClass("test");

      expect(underTest.render().classList.contains("test")).toBeTruthy();
    });

    test("Throws an error when class already exists", () => {
      const underTest = html().create("h2");
      underTest.render().classList.add("test");

      expect(() => {
        underTest.addClass("test");
      }).toThrow("This class already exists");
    });

    describe("addChild", () => {
      test("adds real HTML element", () => {
        const underTest = html().create("h2");
        const elementToAdd = html().create("ul");
        underTest.addChild(elementToAdd);

        expect(underTest.render().querySelector("ul")).toStrictEqual(
          elementToAdd.render()
        );
      });

      test("Throws error if not real HTML element", () => {
        const underTest = html().create("h2");
        const elementToAdd = html().create("fakeHtml");
        console.log(elementToAdd);

        expect(() => underTest.addChild(elementToAdd)).toThrow(
          "Invalid HTML tag"
        );
      });

      describe("text", () => {
        test("Argument sets value", () => {
          const underTest = html().create("h2");
          underTest.text("test text content");

          expect(underTest.text()).toBe("test text content");
        });
      });
      test("Return current value", () => {
        const underTest = html().create("h2");
        underTest.render().textContent = "test text content";

        expect(underTest.text()).toBe("test text content");
      });
    });

    describe("create", () => {
      test("creates an element", () => {
        const underTest = Html().create("h2");

        expect(underTest.render() instanceof HTMLDivElement).toBeTruthy();
      });
    });
  });
});
