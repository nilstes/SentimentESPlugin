package plugin;

import analysis.SentimentAnalyser;
import org.elasticsearch.ingest.AbstractProcessor;
import org.elasticsearch.ingest.IngestDocument;

/**
 * @author nilstes
 */
public class SentimentProcessor extends AbstractProcessor {

    public final static String NAME = "sentiment";

    private SentimentAnalyser analyser = new SentimentAnalyser();
    private String sourceField;
    
    protected SentimentProcessor(String tag, String sourceField) {
        super(tag);
        this.sourceField = sourceField;
    }

    @Override
    public String getType() {
        return NAME;
    }

    @Override
    public void execute(IngestDocument ingestDocument) throws Exception {
        if (ingestDocument.hasField(sourceField)) {
            String message = ingestDocument.getFieldValue(sourceField, String.class);                    
            ingestDocument.setFieldValue(sourceField + "_sentiment", analyser.findSentiment(message));
        }
    }
}