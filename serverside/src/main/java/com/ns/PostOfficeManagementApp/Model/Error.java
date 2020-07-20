package com.ns.PostOfficeManagementApp.Model;

import org.springframework.http.HttpStatus;

public class Error {
        private HttpStatus status;
        private String message;
        private String fieldName;
        private String rejectValue;


        public HttpStatus getStatus() {
            return status;
        }

        public void setStatus(HttpStatus status) {
            this.status = status;
        }

        public String getRejectValue() {
            return rejectValue;
        }

        public void setRejectValue(String rejectValue) {
            this.rejectValue = rejectValue;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }



        public Error() { }

        public Error(HttpStatus status, String message, String fieldName, String rejectValue) {
            this.status = status;
            this.message = message;
            this.fieldName = fieldName;
            this.rejectValue = rejectValue;
        }

        public Error(HttpStatus status, String message) {
            this.status = status;
            this.message = message;

        }
        public Error(HttpStatus status, String message, String rejectValue) {
            this.status = status;
            this.message = message;
            this.rejectValue=rejectValue;
        }
    }


