<template>
  <v-main>
    <div class="instagram-container">
      <div class="profile">
        <div class="profile-image">
          <img src="../assets/mainpage/miso_circle.png" alt="" />
        </div>

        <div class="profile-user-settings">
          <h1 class="profile-user-name">official_miso</h1>
          <span @click="onStartButton">
            <button class="btn profile-follow-btn">start</button>
          </span>
        </div>
        <div class="profile-stats">
          <ul>
            <li><span class="profile-stat-count">164</span> posts</li>
            <li><span class="profile-stat-count">188</span> followers</li>
            <li><span class="profile-stat-count">206</span> following</li>
          </ul>
        </div>

        <div class="profile-bio">
          <p>
            <span class="profile-real-name">official_miso</span>
            <br />
            당신이 몰랐던 그 곳, 미소
            <br />
            인스타그램 핫플레이스를 만나보세요.
          </p>
        </div>
      </div>
      <Story></Story>
      <hr />
    </div>
    <Slider></Slider>
  </v-main>
</template>

<script>
import Story from "@/components/main-page/Story.vue";
import Slider from "@/components/main-page/Slider.vue";
import { VISIT_KEY } from "../utils/constants";

export default {
  name: "App",

  created() {
    localStorage.setItem(VISIT_KEY, VISIT_KEY);
  },

  methods: {
    onStartButton() {
      location.href = "/";
    },
  },

  components: {
    Slider,
    Story,
  },
};
</script>

<style scoped>
@import "../assets/css/instagram.css";
</style>
