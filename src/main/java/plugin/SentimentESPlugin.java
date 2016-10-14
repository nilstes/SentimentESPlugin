package plugin;


import java.util.Collections;
import java.util.Map;
import org.elasticsearch.ingest.Processor;
import org.elasticsearch.plugins.IngestPlugin;
import org.elasticsearch.plugins.Plugin;

/**
 * @author nilstes
 */
public class SentimentESPlugin extends Plugin implements IngestPlugin {
    
    @Override
    public Map<String, Processor.Factory> getProcessors(Processor.Parameters parameters) {
        return Collections.singletonMap("sentiment", new SentimentProcessorFactory());
    }
}
