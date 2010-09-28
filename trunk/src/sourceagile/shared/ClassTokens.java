package sourceagile.shared;

import java.io.Serializable;

public class ClassTokens implements Serializable {

	private static final long serialVersionUID = 1L;

	private int packagePosition;

	private int classPosition;

	private int classDescriptionPositionInit;

	private int classDescriptionPositionEnd;

	public int getPackagePosition() {
		return packagePosition;
	}

	public void setPackagePosition(int packagePosition) {
		this.packagePosition = packagePosition;
	}

	public int getClassPosition() {
		return classPosition;
	}

	public void setClassPosition(int classPosition) {
		this.classPosition = classPosition;
	}

	public int getClassDescriptionPositionInit() {
		return classDescriptionPositionInit;
	}

	public void setClassDescriptionPositionInit(int classDescriptionPositionInit) {
		this.classDescriptionPositionInit = classDescriptionPositionInit;
	}

	public int getClassDescriptionPositionEnd() {
		return classDescriptionPositionEnd;
	}

	public void setClassDescriptionPositionEnd(int classDescriptionPositionEnd) {
		this.classDescriptionPositionEnd = classDescriptionPositionEnd;
	}

}
