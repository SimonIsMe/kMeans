README
======
This package contains k-means algorithms. This algorith is using to split a set of all vectors into _n_ exclusive clusters (groups) of vectors.

An example of use
--------------
```java
// We're creating list of vectors to split into groups.
LinkedList<double[]> vectors = new LinkedList<>();
vectors.add(new double[1, 2, 3]);
vectors.add(new double[2, 3, 4]);
vectors.add(new double[100, 200, 300]);

// We're creating k-means algorithm instance to cluster given vectors.
kMeans kMeans = new kMeans(vectors);

// We're getting objects represents vectors splitted into 2 groups.
kMeansState state = kMeans.findGroups(2);

// We're getting clusters of vectors.
ArrayList<List<double[]>> groupedVectors = state.getGroupedVectors();
```

An example of use in real application
----------------------------------
In this project there are two packages:

* k_means
* window

The _k_mean_ package contains only classes required to run k-means algorithm.

The _window_ package contains simple program. In this program you can put some points into a canvas and split them into clusters using k-means algorithm.

