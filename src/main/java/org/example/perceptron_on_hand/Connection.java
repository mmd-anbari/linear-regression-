package org.example.perceptron_on_hand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Connection {

    private Neuron from;
    private Neuron to;
    private float weight;


}
