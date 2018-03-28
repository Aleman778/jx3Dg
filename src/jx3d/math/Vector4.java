package jx3d.math;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.nio.FloatBuffer;

import jx3d.util.BufferUtils;

/**
 * Represents a four dimensional vector with single-precision.
 * @since 1.0
 * @author Aleman778
 */
public class Vector4 {

	/**
	 * The x component of the four dimensional vector.
	 */
	public float x;
	
	/**
	 * The y component of the four dimensional vector.
	 */
	public float y;
	
	/**
	 * The z component of the four dimensional vector.
	 */
	public float z;
	
	/**
	 * The w component of the four dimensional vector.
	 */
	public float w;
	
	/**
	 * Default Constructor.
	 * Creates an empty vector with all four values set to zero.
	 */
	public Vector4() {
		this(0, 0, 0, 0);
	}
	
	/**
	 * Constructor.
	 * @param x the value of the x component of the vector
	 * @param y the value of the y component of the vector
	 * @param z the value of the z component of the vector
	 * @param w the value of the w component of the vector
	 */
	public Vector4(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	/**
	 * Constructor used to create a new copy of the provided vector.
	 * @param copy the vector to copy from
	 */
	public Vector4(Vector4 copy) {
		this.x = copy.x;
		this.y = copy.y;
		this.z = copy.z;
		this.w = copy.w;
	}
	
	/**
	 * Set all four components in the vector to the provided value.
	 * @param d the value of all four entries
	 * @return this vector
	 */
	public Vector4 set(float d) {
		return set(d, d, d, d);
	}
	
	/**
	 * Set the x, y, z and w components in the vector to the provided values.
	 * @param x the value of the x component to set
	 * @param y the value of the y component to set
	 * @param z the value of the z component to set
	 * @param w the value of the w component to set
	 * @return this vector
	 */
	public Vector4 set(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
		return this;
	}
	
	/**
	 * Set this vector to the values of the given vector <code>v</code>.
	 * @param v the vector to copy from
	 * @return this vector
	 */
	public Vector4 set(Vector4 v) {
		return set(v.x, v.y, v.z, v.w);
	}

	/**
	 * Add the components of this vector by the given values.
	 * @param x the x component to add
	 * @param y the y component to add
	 * @param z the z component to add
	 * @param w the w component to add
	 * @return a new vector holding the result
	 */
	public Vector4 add(float x, float y, float z, float w) {
		return new Vector4(this.x + x, this.y + y, this.z + z, this.w + w);
	}
	
	/**
	 * Add the components of this vector by the given vector <code>v</code>.
	 * @param v the vector to add
	 * @return a new vector holding the result
	 */
	public Vector4 add(Vector4 v) {
		return new Vector4(x + v.x, y + v.y, z + v.z, w + v.w);
	}
	

	/**
	 * Subtract the components of this vector by the given values.
	 * @param x the x component to subtract
	 * @param y the y component to subtract
	 * @param z the z component to subtract
	 * @param w the w component to subtract
	 * @return a new vector holding the result
	 */
	public Vector4 sub(float x, float y, float z, float w) {
		return new Vector4(this.x - x, this.y - y, this.z - z, this.w - w);
	}
	
	/**
	 * Subtract the components of this vector by the given vector <code>v</code>.
	 * @param v the vector to subtract
	 * @return a new vector holding the result
	 */
	public Vector4 sub(Vector4 v) {
		return new Vector4(x - v.x, y - v.y, z - v.z, w - v.w);
	}
	
	/**
	 * Multiply the components of this vector by the given scalar <code>s</code>.
	 * @param s the scalar to multiply
	 * @return a new vector holding the result
	 */
	public Vector4 mul(float s) {
		return new Vector4(x * s, y * s, z * s, w * s);
	}
	
	/**
	 * Multiply the components of this vector by the given values.
	 * @param x the x component to multiply
	 * @param y the y component to multiply
	 * @param z the z component to multiply
	 * @param w the w component to multiply
	 * @return a new vector holding the result
	 */
	public Vector4 mul(float x, float y, float z, float w) {
		return new Vector4(this.x * x, this.y * y, this.z * z, this.w * w);
	}
	
	/**
	 * Multiply the components of this vector by the components of the given vector.
	 * @param v the vector to multiply
	 * @return a new vector holding the result
	 */
	public Vector4 mul(Vector4 v) {
		return new Vector4(x * v.x, y * v.y, z * v.z, w * v.w);
	}
	
	/**
	 * Inverts (or negates) each component in this vector.
	 * @return a new vector holding the result
	 */
	public Vector4 inverse() {
		return new Vector4(-x, -y, -z, -w);
	}
	
	/**
	 * Multiply the components of this vector by the given values.
	 * @param x the x component to multiply
	 * @param y the y component to multiply
	 * @param k the z component to multiply
	 * @param w the w component to multiply
	 * @return the dot product of the the to vectors
	 */
	public float dot(float x, float y) {
		return this.x * x + this.y * y + this.z * z + this.w * w;	
	}
	
	/**
	 * Multiply the components if thus vector by the components of the given vector.
	 * @param v the vector to multiply
	 * @return the dot product of the the to vectors
	 */
	public float dot(Vector4 v) {
		return x * v.x + y * v.y + z * v.z + w * v.w;	
	}
	
	/**
	 * Get the length (or magnitude) of the vector.
	 * @return the length of the vector
	 * @see Vector4#lengthSquared()
	 */
	public float length() {
		return (float) Math.sqrt(x * x + y * y + z * z + w * w);
	}
	
	/**
	 * Computes the length (or magnitude) of the vector squared.
	 * This function is faster when comparing two lengths.
	 * @return the length of the vector squared
	 * @see Vector4#length()
	 */
	public float lengthSquared() {
		return x * x + y * y + z * z + w * w;
	}
	
	/**
	 * Computes the distance between the point of this vector and the provided point. 
	 * @param x the x component of point
	 * @param y the y component of point
	 * @param z the z component of point
	 * @param w the w component of point
	 * @return the distance between the two points
	 */
	public float distance(float x, float y, float z, float w) {
		float dx = this.x - x;
		float dy = this.y - y;
		float dz = this.z - z;
		float dw = this.w - w;
		return (float) Math.sqrt(dx * dx + dy * dy + dz * dz + dw * dw);
	}

	/**
	 * Computes the distance squared between the point of this vector and the provided point. 
	 * @param x the x component of point
	 * @param y the y component of point
	 * @param z the z component of point
	 * @param w the w component of point
	 * @return the distance between the two points
	 */
	public float distanceSquared(float x, float y, float z, float w) {
		float dx = this.x - x;
		float dy = this.y - y;
		float dz = this.z - z;
		float dw = this.w - w;
		return dx * dx + dy * dy + dz * dz + dw * dw;
	}
	
	/**
	 * Computes the distance between the points of this vector and the point of the provided vector <code>v</code>.
	 * @param v the point of the vector
	 * @return the distance between the two vectors points
	 */
	public float distance(Vector4 v) {
		return distance(v.x, v.y, v.z, v.w);
	}

	/**
	 * Computes the distance <b>squared</b> between the points of this vector and the point of the provided vector <code>v</code>.
	 * This function is faster when comparing two distances.
	 * @param v the point of the vector
	 * @return the distance between the two vectors points
	 */
	public float distanceSquared(Vector4 v) {
		return distanceSquared(v.x, v.y, v.z, v.w);
	}
	
	/**
	 * Normalize this vector.
	 * @return this vector
	 * @throws IllegalStateException if this vector is a zero vector i.e. length is zero
	 */
	public Vector4 normalize() throws IllegalStateException {
		float invLength = (float) Math.sqrt(x * x + y * y + z * z + w * w);
		if (invLength > 0.0f) {
			invLength = 1.0f / invLength;
			x *= invLength;
			y *= invLength;
			z *= invLength;
			w *= invLength;
		} else {
			throw new IllegalStateException("Cannot normalize a zero vector.");
		}
		return this;
	}
	
	/**
	 * Get the linearly interpolated vector from this to the provided target vector <code>v</code> at time <code>t</code>.
	 * The result is stored in <code>dest</code>.
	 * @param v the target vector
	 * @param t the time from [0..1]
	 * @param dest the vector to hold the result in
	 * @return the dest vector
	 */
	public Vector4 lerp(Vector4 v, float t, Vector4 dest) {
		dest.x = x + (v.x - x) * t;
		dest.y = y + (v.y - y) * t;
		dest.z = z + (v.z - z) * t;
		dest.w = w + (v.w - w) * t;
		return dest;
	}
	
	/**
	 * Get the linearly interpolated vector from this to the provided target vector <code>v</code> at time <code>t</code>.
	 * <i>Note:</i> the result is held in this vector.
	 * @param v the target vector
	 * @param t the time from [0..1]
	 * @return this vector
	 */
	public Vector4 lerp(Vector4 v, float t) {
		return lerp(v, t, this);
	}
	
	/**
	 * Write vector data to external source.
	 * @param out output source
	 * @throws IOException if an I/O error occurs
	 */
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeFloat(x);
		out.writeFloat(y);
		out.writeFloat(z);
		out.writeFloat(w);
	}
	
	/**
	 * Read vector data from external source.
	 * @param in input source
	 * @throws IOException if an I/O error occurs
	 */
	public void readExternal(ObjectInput in) throws IOException {
		x = in.readFloat();
		y = in.readFloat();
		z = in.readFloat();
		w = in.readFloat();
	}
	
	/**
	 * Returns the components of this vector in a float buffer.
	 * @return a new float buffer
	 */
	public FloatBuffer toFloatBuffer() {
		return BufferUtils.createFloatBuffer(x, y, z, w);
	}
	
	@Override
	public String toString() {
		return "Vector4: (" + x + ", " + y + ", " + z + ", " + w + ")";
	}
}
