/**

Copyright (C) SYSTAP, LLC 2006-2012.  All rights reserved.

Contact:
     SYSTAP, LLC
     4501 Tower Road
     Greensboro, NC 27410
     licenses@bigdata.com

This program is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; version 2 of the License.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/
/*
 * Created on Mar 29, 2012
 */

package com.bigdata.rdf.sparql.ast.service;

import org.apache.http.conn.ClientConnectionManager;
import org.openrdf.model.URI;

import com.bigdata.rdf.store.AbstractTripleStore;

/**
 * Interface for the parameters used by a {@link ServiceFactory} to create a
 * {@link ServiceCall} instance.
 * 
 * @author <a href="mailto:thompsonbry@users.sourceforge.net">Bryan Thompson</a>
 */
public interface ServiceCallCreateParams {

    /**
     * The end point for which the {@link ServiceCall} will be invoked.
     */
    URI getServiceURI();
    
    /**
     * The {@link AbstractTripleStore} against which the query is being
     * evaluated.
     */
    AbstractTripleStore getTripleStore();

    /**
     * The bigdata AST object modeling the SPARQL <code>SERVICE</code> clause.
     * This object provides access to the parsed structure of the SERVICE graph
     * pattern and the original text image of the graph pattern (assuming that
     * it was generated by parsing a SPARQL query). The {@link ServiceFactory}
     * can use this information to interpret the {@link ServiceCall} invocation
     * context.
     */
    ServiceNode getServiceNode();
    
    /**
     * Return the {@link ClientConnectionManager} used to make remote SERVICE
     * call requests.
     */
    ClientConnectionManager getClientConnectionManager();

    /**
     * The configuration options associated with the {@link ServiceFactory}.
     */
    IServiceOptions getServiceOptions();

}
