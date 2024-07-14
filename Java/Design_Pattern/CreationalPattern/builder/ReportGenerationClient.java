
// Builder Interface: ReportBuilder

interface ReportBuilder {
    void addTitle(String title);

    void addContent(String content);

    void addChart(String chartData);
    // Other methods for adding components as needed
}

// Concrete Builder: PDFReportBuilder
class PDFReportBuilder implements ReportBuilder {
    private StringBuilder report = new StringBuilder();

    @Override
    public void addTitle(String title) {
        report.append("PDF Report Title: ").append(title).append("\n");
    }

    @Override
    public void addContent(String content) {
        report.append("PDF Report Content: ").append(content).append("\n");
    }

    @Override
    public void addChart(String chartData) {
        report.append("PDF Chart: ").append(chartData).append("\n");
    }

    // Other methods specific to PDF report construction
    public String getResult() {
        return report.toString();
    }
}

// Concrete Builder: HTMLReportBuilder
class HTMLReportBuilder implements ReportBuilder {
    private StringBuilder report = new StringBuilder();

    @Override
    public void addTitle(String title) {
        report.append("<h1>").append(title).append("</h1>\n");
    }

    @Override
    public void addContent(String content) {
        report.append("<p>").append(content).append("</p>\n");
    }

    @Override
    public void addChart(String chartData) {
        report.append("<div>").append("HTML Chart: ").append(chartData).append("</div>\n");
    }

    // Other methods specific to HTML report construction
    public String getResult() {
        return report.toString();
    }
}

// Director (optional): ReportDirector
// Manages the order of steps to construct a report

// Client Code
public class ReportGenerationClient {
    public static void main(String[] args) {
        // Create a PDF report using PDFReportBuilder
        PDFReportBuilder pdfBuilder = new PDFReportBuilder();
        constructReport(pdfBuilder); // Director or client manages construction steps
        String pdfReport = pdfBuilder.getResult();
        System.out.println("Generated PDF Report:\n" + pdfReport);

        System.out.println();

        // Create an HTML report using HTMLReportBuilder
        HTMLReportBuilder htmlBuilder = new HTMLReportBuilder();
        constructReport(htmlBuilder); // Director or client manages construction steps
        String htmlReport = htmlBuilder.getResult();
        System.out.println("Generated HTML Report:\n" + htmlReport);
    }

    public static void constructReport(ReportBuilder builder) {
        builder.addTitle("Monthly Report");
        builder.addContent("This is the content of the monthly report...");
        builder.addChart("Chart data goes here...");
        // Other construction steps as needed
    }
}
