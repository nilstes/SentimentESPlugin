package plugin;

import java.util.Map;
import org.elasticsearch.ingest.ConfigurationUtils;
import org.elasticsearch.ingest.Processor;

/**
 * @author nilstes
 */
public class SentimentProcessorFactory implements Processor.Factory {
    @Override
    public Processor create(Map<String, Processor.Factory> processorFactories, String tag, Map<String, Object> config)
                  throws Exception {
        String source = ConfigurationUtils.readStringProperty(SentimentProcessor.NAME, tag, config, "source", "message");
        return new SentimentProcessor(tag, source);
    }
}