package com.app.responsePojos;

import com.app.utils.Properties;

public class File {
 private String path;
 private String createdDate;
 private float size;
 private String parentFolderId;
 private String name;
 private String modifiedDate;
 private String id;
 private boolean directory;
 Properties PropertiesObject;


 // Getter Methods 

 public String getPath() {
  return path;
 }

 public String getCreatedDate() {
  return createdDate;
 }

 public float getSize() {
  return size;
 }

 public String getParentFolderId() {
  return parentFolderId;
 }

 public String getName() {
  return name;
 }

 public String getModifiedDate() {
  return modifiedDate;
 }

 public String getId() {
  return id;
 }

 public boolean getDirectory() {
  return directory;
 }

 public Properties getProperties() {
  return PropertiesObject;
 }

 // Setter Methods 

 public void setPath(String path) {
  this.path = path;
 }

 public void setCreatedDate(String createdDate) {
  this.createdDate = createdDate;
 }

 public void setSize(float size) {
  this.size = size;
 }

 public void setParentFolderId(String parentFolderId) {
  this.parentFolderId = parentFolderId;
 }

 public void setName(String name) {
  this.name = name;
 }

 public void setModifiedDate(String modifiedDate) {
  this.modifiedDate = modifiedDate;
 }

 public void setId(String id) {
  this.id = id;
 }

 public void setDirectory(boolean directory) {
  this.directory = directory;
 }

 public void setProperties(Properties propertiesObject) {
  this.PropertiesObject = propertiesObject;
 }
}
