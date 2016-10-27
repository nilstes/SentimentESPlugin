# SentimentESPlugin

Install plugin:
```
bin/elasticsearch-plugin install file:///path/to/target/releases/sentiment-es-plugin-1.0.zip
```

Create ElasticSearch pipeline:
```
curl -XPUT localhost:9200/_ingest/pipeline/sentiment -d '{"processors" : [{"sentiment" : { "source": "message" }}]}'
```
