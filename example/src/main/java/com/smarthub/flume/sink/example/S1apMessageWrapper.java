package com.smarthub.flume.sink.example;

import com.smarthub.flume.sink.MessageTransformationException;
import com.smarthub.flume.sink.MessageWrapper;

public class S1apMessageWrapper implements MessageWrapper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int startTime;
	private int startTimeUSec;
	private int endTime;
	private int endTimeUSec;
	private int callType;
	private int status;
	private int callNumber;
	private int imsi;
	private int imei;
	private int lac;
	private int cellId;
	private int transactionType;
	private int transStatsStatusBits;
	private int transProtocolId;
	private String protocolName = "s1ap";

	@Override
	public MessageWrapper wrap(String msg) throws MessageTransformationException {
		String values[] = removeDoubleQuotes(msg).split(",", -1);

		// if (values[10].equalsIgnoreCase(""))
		// throw new MessageTransformationException("Unable to transform
		// message: " + msg);

		try {
			this.startTime = tryParseInt(values[0]);
			this.startTimeUSec = tryParseInt(values[1]);
			this.endTime = tryParseInt(values[2]);
			this.endTimeUSec = tryParseInt(values[3]);
			this.callType = tryParseInt(values[4]);
			this.status = tryParseInt(values[5]);
			this.callNumber = tryParseInt(values[6]);
			this.imsi = tryParseInt(values[7]);
			this.imei = tryParseInt(values[8]);
			this.lac = tryParseInt(values[9]);
			this.cellId = tryParseInt(values[10]);
			this.transactionType = tryParseInt(values[11]);
			this.transStatsStatusBits = tryParseInt(values[12]);
			this.transProtocolId = tryParseInt(values[13]);
		} catch (Exception e) {
			throw new MessageTransformationException("Unable to transform message: " + e + " msg:"
					+ removeDoubleQuotes(msg) + " array length:" + values.length);
		}

		return this;
	}

	private int tryParseInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException nfe) {
			// Log exception.
			return 0;
		}
	}

	/**
	 *
	 * @param value
	 * @return
	 */
	private String removeDoubleQuotes(String value) {

		return value.replaceAll("\"", "");

	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getStartTimeUSec() {
		return startTimeUSec;
	}

	public void setStartTimeUSec(int startTimeUSec) {
		this.startTimeUSec = startTimeUSec;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public int getEndTimeUSec() {
		return endTimeUSec;
	}

	public void setEndTimeUSec(int endTimeUSec) {
		this.endTimeUSec = endTimeUSec;
	}

	public int getCallType() {
		return callType;
	}

	public void setCallType(int callType) {
		this.callType = callType;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCallNumber() {
		return callNumber;
	}

	public void setCallNumber(int callNumber) {
		this.callNumber = callNumber;
	}

	public int getImsi() {
		return imsi;
	}

	public void setImsi(int imsi) {
		this.imsi = imsi;
	}

	public int getImei() {
		return imei;
	}

	public void setImei(int imei) {
		this.imei = imei;
	}

	public int getLac() {
		return lac;
	}

	public void setLac(int lac) {
		this.lac = lac;
	}

	public int getCellId() {
		return cellId;
	}

	public void setCellId(int cellId) {
		this.cellId = cellId;
	}

	public int getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}

	public int getTransStatsStatusBits() {
		return transStatsStatusBits;
	}

	public void setTransStatsStatusBits(int transStatsStatusBits) {
		this.transStatsStatusBits = transStatsStatusBits;
	}

	public int getTransProtocolId() {
		return transProtocolId;
	}

	public void setTransProtocolId(int transProtocolId) {
		this.transProtocolId = transProtocolId;
	}

	public String getProtocolName() {
		return protocolName;
	}

	public void setProtocolName(String protocolName) {
		this.protocolName = protocolName;
	}

}
