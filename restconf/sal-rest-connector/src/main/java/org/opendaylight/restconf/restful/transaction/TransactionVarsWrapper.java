/*
 * Copyright (c) 2016 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.restconf.restful.transaction;

import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.controller.md.sal.dom.api.DOMDataReadWriteTransaction;
import org.opendaylight.controller.md.sal.dom.api.DOMMountPoint;
import org.opendaylight.netconf.sal.restconf.impl.InstanceIdentifierContext;

/**
 * This class represent delegation wrapper for transaction variables.
 *
 */
public final class TransactionVarsWrapper {

    private final InstanceIdentifierContext<?> instanceIdentifier;
    private final DOMMountPoint mountPoint;
    private LogicalDatastoreType configuration = null;
    private final DOMDataReadWriteTransaction transaction;

    /**
     * Set base type of variables, which ones we need for transaction.
     * {@link LogicalDatastoreType} is default set to null (to read all data
     * from DS - config + state).
     *
     * @param instanceIdentifier
     *            - {@link InstanceIdentifierContext} of data for transaction
     * @param mountPoint
     *            - mount point if is present
     * @param transaction
     *            - {@link DOMDataReadWriteTransaction} transaction for
     *            operations
     */
    public TransactionVarsWrapper(final InstanceIdentifierContext<?> instanceIdentifier, final DOMMountPoint mountPoint,
            final DOMDataReadWriteTransaction transaction) {
        this.instanceIdentifier = instanceIdentifier;
        this.mountPoint = mountPoint;
        this.transaction = transaction;
    }

    /**
     * Get instance identifier of data
     *
     * @return {@link InstanceIdentifierContext}
     */
    public InstanceIdentifierContext<?> getInstanceIdentifier() {
        return this.instanceIdentifier;
    }

    /**
     * Get mount point
     *
     * @return {@link DOMMountPoint}
     */
    public DOMMountPoint getMountPoint() {
        return this.mountPoint;
    }

    /**
     * Set {@link LogicalDatastoreType} of data for transaction.
     *
     * @param configuration
     *            - {@link LogicalDatastoreType}
     */
    public void setLogicalDatastoreType(final LogicalDatastoreType configuration) {
        this.configuration = configuration;

    }

    /**
     * Get type of data.
     *
     * @return {@link LogicalDatastoreType}
     */
    public LogicalDatastoreType getLogicalDatastoreType() {
        return this.configuration;
    }

    /**
     * Get specific type of transaction
     *
     * @return specific type transaction
     */
    public DOMDataReadWriteTransaction getTransaction() {
        return this.transaction;
    }
}
