// Abstract Product: Document
interface Document {
    void open();

    void save();
}

// Concrete Products: WordDocument, PDFDocument, HTMLDocument
class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word document");
    }

    @Override
    public void save() {
        System.out.println("Saving Word document");
    }
}

class PDFDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document");
    }

    @Override
    public void save() {
        System.out.println("Saving PDF document");
    }
}

class HTMLDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening HTML document");
    }

    @Override
    public void save() {
        System.out.println("Saving HTML document");
    }
}

// Factory Method Interface: DocumentFactory
interface DocumentFactory {
    Document createDocument();
}

// Concrete Factories: WordDocumentFactory, PDFDocumentFactory,
// HTMLDocumentFactory
class WordDocumentFactory implements DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

class PDFDocumentFactory implements DocumentFactory {
    @Override
    public Document createDocument() {
        return new PDFDocument();
    }
}

class HTMLDocumentFactory implements DocumentFactory {
    @Override
    public Document createDocument() {
        return new HTMLDocument();
    }
}

// Client Code
public class Factory_problem_1 {
    public static void main(String[] args) {
        // Create a Word document using WordDocumentFactory
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDocument = wordFactory.createDocument();
        wordDocument.open();
        wordDocument.save();

        System.out.println();

        // Create a PDF document using PDFDocumentFactory
        DocumentFactory pdfFactory = new PDFDocumentFactory();
        Document pdfDocument = pdfFactory.createDocument();
        pdfDocument.open();
        pdfDocument.save();

        System.out.println();

        // Create an HTML document using HTMLDocumentFactory
        DocumentFactory htmlFactory = new HTMLDocumentFactory();
        Document htmlDocument = htmlFactory.createDocument();
        htmlDocument.open();
        htmlDocument.save();
    }
}
