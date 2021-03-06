export default function() {
  return new Html();
}

class Html {
  addAttribute(attributeToSet, attributeValue) {
    this.element.setAttribute(attributeToSet, attributeValue);

    return this;
  }

  click(callback) {
    this.element.addEventListener("click", callback);

    return this;
  }

  create(elementType) {
    this.element = document.createElement(elementType);
    return this;
  }

  addChild(elementToAdd) {
    if (elementToAdd.render() instanceof HTMLUnknownElement) {
      throw new Error("Invalid HTML tag");
    }

    this.element.append(elementToAdd.render());

    return this;
  }

  addClass(classToAdd) {
    if (this.element.classList.contains(classToAdd)) {
      throw new Error("This class already exists");
    }
    this.element.classList.add(classToAdd);
    return this;
  }

  addHtml(contentToAdd) {
    if (contentToAdd === undefined) {
      return this.element.innerHTML;
    }
    this.element.innerHTML = contentToAdd;

    return this;
  }

  isClassQuery(query) {
    return query.startsWith(".");
  }

  isIdQuery(query) {
    return query.startsWith("#");
  }

  render() {
    return this.element;
  }

  replace(element) {
    this.element.innerHTML = "";
    this.addChild(element);

    return this;
  }

  select(query) {
    const selection = document.querySelectorAll(query);

    if (selection.length === 1) {
      this.element = selection[0];
    } else {
      this.element = selection;
    }

    return this;
  }

  text(textToAdd) {
    if (textToAdd === undefined) {
      return this.element.textContent;
    }
    this.element.textContent = textToAdd;
    return this;
  }
}
