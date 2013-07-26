package diogo;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import yaps.graph_library.GraphReader;
import yaps.graph_library.NodeSelectedSubGraph;
import yaps.graph_library.Path;
import yaps.graph_library.PathBuilder;

public class PartitionTest {

	public static void main(String[] args) throws IOException {
		PreCalculedPathGraph g = new PreCalculedPathGraph(GraphReader.readAdjacencyList("./maps/island11"));
			
		List<Integer> centerList = GraphEquipartition.maximumDistance(4, g);

		HashMap<Integer, List<Integer>> map = GraphEquipartition.fungalColonyPartition(centerList, g, true);
		
		HashMap<Integer, NodeSelectedSubGraph> graphMap = 
				new HashMap<Integer, NodeSelectedSubGraph>();
		
		HashMap<Integer, Path> pathMap = new HashMap<Integer, Path>();
		
		for(Integer c: centerList){
			graphMap.put(c, new NodeSelectedSubGraph(map.get(c), g));
			pathMap.put(c, PathBuilder.nearestInsertionMethod(graphMap.get(c)));
		}
		
		int j =0;
		
	}

}
