package GeneticAlgorithm.Crossover

import GeneticAlgorithm._

case class CrossoverMethod(Crossover: (Chromosome, Chromosome) => Chromosome)