package com.ityj.design.builder.demo;

public class Phone {
    private String screen;
    private String battery;
    private String chip;
    private String os;

    private Phone(PhoneBuilder builder) {
        this.screen = builder.screen;
        this.battery = builder.battery;
        this.chip = builder.chip;
        this.os = builder.os;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "screen='" + screen + '\'' +
                ", battery='" + battery + '\'' +
                ", chip='" + chip + '\'' +
                ", os='" + os + '\'' +
                '}';
    }

    public static class PhoneBuilder {
        private String screen;
        private String battery;
        private String chip;
        private String os;

        public PhoneBuilder screen(String screen) {
            this.screen = screen;
            return this;
        }

        public PhoneBuilder battery(String battery) {
            this.battery = battery;
            return this;
        }

        public PhoneBuilder chip(String chip) {
            this.chip = chip;
            return this;
        }

        public PhoneBuilder os(String os) {
            this.os = os;
            return this;
        }

        public Phone newPhone() {
            return new Phone(this);
        }
    }
}
