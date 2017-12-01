package com.gigaspaces.exercise.common;

import com.j_spaces.core.IJSpace;
import com.j_spaces.core.cluster.IReplicationFilter;
import com.j_spaces.core.cluster.IReplicationFilterEntry;
import com.j_spaces.core.cluster.ReplicationPolicy;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;

import java.util.logging.Logger;

/**
 * @author Yael Nahon
 * @since 12.3
 */
public class Filter implements IReplicationFilter {

    GigaSpace gigaspace = null;
    Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    public void init(IJSpace space, String paramUrl,
                     ReplicationPolicy replicationPolicy) {

        gigaspace = new GigaSpaceConfigurer(space).gigaSpace();
        log.info("Replication Filter - Created " + gigaspace);
    }

    @Override
    public void process(int direction, IReplicationFilterEntry replicationEntry, String remoteSpaceMemberName) {
        if (!(Boolean) replicationEntry.getFieldValue("eligible")) {
            replicationEntry.discard();
        }
        if (direction == IReplicationFilter.FILTER_DIRECTION_INPUT) {
            log.info("Blocked incoming entry with id = " + replicationEntry.getFieldValue("id"));
        } else {
            log.info("Blocked outgoing entry with id = " + replicationEntry.getFieldValue("id"));
        }
    }

    @Override
    public void close() {

    }
}