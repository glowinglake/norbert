/*
 * Copyright 2009-2010 LinkedIn, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.linkedin.norbert.network.javaapi;

import com.linkedin.norbert.cluster.InvalidClusterException;
import com.linkedin.norbert.cluster.Node;

import java.util.Random;

public class RoundRobinLoadBalancerFactory implements LoadBalancerFactory {
  public LoadBalancer newLoadBalancer(Node[] nodes) throws InvalidClusterException {
    return new RoundRobinLoadBalancer(nodes);
  }

  private static class RoundRobinLoadBalancer implements LoadBalancer {
    private final Random random = new Random();
    private final Node[] nodes;

    private RoundRobinLoadBalancer(Node[] nodes) {
      this.nodes = nodes;
    }

    public Node nextNode() {
      return nodes[random.nextInt(nodes.length)];
    }
  }
}
