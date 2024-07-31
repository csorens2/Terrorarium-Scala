package GeneticAlgorithm.Selection

import GeneticAlgorithm.Individual

case class SelectionMethod(select: Vector[Individual] => Individual)