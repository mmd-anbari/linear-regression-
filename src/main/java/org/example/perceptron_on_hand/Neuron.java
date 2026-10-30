package org.example.perceptron_on_hand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Neuron {

    private float bias;
    private float output;
    private ArrayList<Connection> incomingConnections;
    private ArrayList<Connection> outgoingConnections;

}
