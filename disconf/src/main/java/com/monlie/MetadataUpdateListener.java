package com.monlie;

import org.apache.kafka.clients.Metadata;
import org.apache.kafka.common.Cluster;

import java.util.Set;

public class MetadataUpdateListener implements Metadata.Listener {

    public void onMetadataUpdate(Cluster cluster, Set<String> unavailableTopics) {

    }
}
