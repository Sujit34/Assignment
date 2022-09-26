package Lab12.Problem1;

public class Test {

	public static void main(String[] args) {

		Triangle t = null;
		Square s = null;
		Rectangle r = null;
		Circle c = null;

		ClosedCurve[] objects = new ClosedCurve[4];
		int index = 0;

		try {
			t = new Triangle(1, 2, 6);
			objects[index++] = t;
		} catch (IllegalClosedCurveException e) {
			System.out.println(e.getMessage());
		}

		try {
			s = new Square(-3);
			objects[index++] = s;
		} catch (IllegalClosedCurveException e) {
			System.out.println(e.getMessage());
		}

		try {
			r = new Rectangle(-3, 7);
			objects[index++] = r;
		} catch (IllegalClosedCurveException e) {
			System.out.println(e.getMessage());
		}

		try {
			c = new Circle(-3);
			objects[index++] = c;
		} catch (IllegalClosedCurveException e) {
			System.out.println(e.getMessage());
		}

		// compute areas
		for (ClosedCurve cc : objects) {
			if(cc != null) {
				String nameOfCurve = getClassNameNoPackage(cc.getClass());

				System.out.println("The area of this " + nameOfCurve + " is " + cc.computeArea());
			}
		}

	}

	public static String getClassNameNoPackage(Class aClass) {
		String fullClassName = aClass.getName();
		int index = fullClassName.lastIndexOf('.');
		String className = null;
		String packageName = null;

		// in this case, there is no package name
		if (index == -1) {
			return fullClassName;
		} else {
			// for other apps, may be useful to have this
			packageName = fullClassName.substring(0, index);

			className = fullClassName.substring(index + 1);
			return className;
		}

	}

}
