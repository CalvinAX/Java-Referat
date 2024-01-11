<template>
    <div class="ticket-page2">
        <h1>Tickets</h1>
        <!-- <form @submit.prevent>
            <input type="text">
        </form> -->
        <div class="searchbar">
            <form @submit.prevent="">
                <input v-model="search" type="search" placeholder="Search Tickets">
                <button type="submit"></button>
            </form>
        </div>
        <!-- {{ resultObject }} -->
        <div class="search-options">
            <!-- <div class="inter" @click="searchOptions = !searchOptions">
                <span>search options</span>
                <span class="icon" :class="{ active: searchOptions }"><svg height="10px" width="10px" version="1.1"
                        id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                        viewBox="0 0 185.343 185.343" xml:space="preserve">
                        <path style="fill:#B6C2CF;" d="M51.707,185.343c-2.741,0-5.493-1.044-7.593-3.149c-4.194-4.194-4.194-10.981,0-15.175
			l74.352-74.347L44.114,18.32c-4.194-4.194-4.194-10.987,0-15.175c4.194-4.194,10.987-4.194,15.18,0l81.934,81.934
			c4.194,4.194,4.194,10.987,0,15.175l-81.934,81.939C57.201,184.293,54.454,185.343,51.707,185.343z" />
                    </svg></span>
            </div>
            <div class="options" v-if="searchOptions">
                <span>
                    <input type="checkbox" v-model="check.title" checked>
                    {{ $t('ticket.title') }}
                </span>
                <span>
                    <input type="checkbox" v-model="check.creator">
                    {{ $t('ticket.creator') }}
                </span>
                <span>
                    <input type="checkbox" v-model="check.assignee">
                    {{ $t('ticket.assignee') }}
                </span>
                <span>
                    <input type="checkbox" v-model="check.status">
                    {{ $t('ticket.status') }}
                </span>
                <span>
                    <input type="checkbox" v-model="check.priority">
                    {{ $t('ticket.priority') }}
                </span>
                <span>
                    <input type="checkbox" v-model="check.created_at">
                    {{ $t('ticket.created_at') }}
                </span>
                <span>
                    <input type="checkbox" v-model="check.deadline">
                    {{ $t('ticket.deadline') }}
                </span>
            </div> -->
        </div>
        <!-- {{ search }}
        <br>
        {{ filteredResult }} -->
        <!-- {{ now }} -->
        <div class="ticket-grid">
            <div class="row header">
                <span class="cell">{{ $t('ticket.title') }}</span>
                <span class="cell">{{ $t('ticket.creator') }}</span>
                <span class="cell">{{ $t('ticket.assignee') }}</span>
                <span class="cell">{{ $t('ticket.status') }}</span>
                <span class="cell">{{ $t('ticket.priority') }}</span>
                <span class="cell">{{ $t('ticket.created_at') }}</span>
                <span class="cell">{{ $t('ticket.deadline') }}</span>
            </div>
            <!-- <Ticket class="row" v-for="result in filteredResult" key="result.id" :result="result" /> -->
            <Ticket class="row" v-for="result in responseData" :key="result.id" :result="result" />
        </div>

    </div>
</template>

<script setup lang="ts">
const searchOptions = ref(false)

interface CheckboxState {
    [key: string]: boolean;
}
const check = ref<CheckboxState>({
    'title': true,
    'creator': false,
    'assignee': false,
    'status': false,
    'priority': false,
    'created_at': false,
    'deadline': false,
});

// const resultObject = ref([{
//     id: "1",
//     title: "Wichtige Fehlerbehebung",
//     description: "Ein kritischer Fehler muss behoben werden, der das System beeinträchtigt.",
//     creator: "Maria",
//     closed_by: null, // Noch nicht geschlossen
//     assignee: "Alex",
//     status: "Open",
//     priority: "High",
//     created_at: "02.01.2024",
//     deadline: "11. Feb. 10:26 Uhr"
// },
// {
//     id: "2",
//     title: "WIcht Funktionalität hinzufügen",
//     description: "Es soll eine neue Funktion implementiert werden, um die Benutzererfahrung zu verbessern.",
//     creator: "Chris",
//     closed_by: null, // Noch nicht geschlossen
//     assignee: "Sarah",
//     status: "In Progress",
//     priority: "Medium",
//     created_at: "02.01.2024",
//     deadline: "11. Feb. 10:26 Uhr"
// },
// {
//     id: "3",
//     title: "Benutzeroberfläche optimieren",
//     description: "Die Benutzeroberfläche muss für eine bessere Benutzerfreundlichkeit optimiert werden.",
//     creator: "Alice",
//     closed_by: null, // Noch nicht geschlossen
//     assignee: "Bob",
//     status: "Open",
//     priority: "Medium",
//     created_at: "02.01.2024",
//     deadline: "11. Feb. 10:26 Uhr"
// },
// {
//     id: "4",
//     title: "Sicherheitspatch anwenden",
//     description: "Es muss ein Sicherheitspatch angewendet werden, um bekannte Schwachstellen zu beheben.",
//     creator: "David",
//     closed_by: null, // Noch nicht geschlossen
//     assignee: "Eva",
//     status: "In Progress",
//     priority: "High",
//     created_at: "02.01.2024",
//     deadline: "11. Feb. 10:26 Uhr"
// },
// {
//     id: "5",
//     title: "Dokumentation aktualisieren",
//     description: "Die Dokumentation muss auf den neuesten Stand gebracht werden, um Änderungen zu reflektieren.",
//     creator: "Grace",
//     closed_by: "John",
//     assignee: "John",
//     status: "Closed",
//     priority: "Low",
//     created_at: "02.01.2024",
//     deadline: "11. Feb. 10:26 Uhr"
// }])

interface Task {
    id: string;
    title: string;
    description: string;
    creator: string;
    closed_by: string | null;
    assignee: string;
    status: string;
    priority: string;
    created_at: string;
    deadline: string;
}

// const search = ref(null)
const search = ref<string | null>(null);

// const filterByTitle = (array: Task[], searchTerm: string | null) => {
//     if (!searchTerm) return array;
//     return array.filter(item => item.title.toLowerCase().startsWith(searchTerm.toLowerCase()));
// };

// const filteredResult = ref<Task[]>([])
// const filteredResult = ref(resultObject)
// watch(search, () => {
//     if (search.value !== null) {
//         filteredResult.value = filterByTitle(resultObject.value, search.value);
//     }
// });

// const now = computed(() => filteredResult.value)
const responseData = ref()
onMounted(async () => {
    try {
        const response = await fetch('/api/tickets')
        if (!response.ok) {
            throw new Error('No available data');
        }
        const data = await response.json();
        responseData.value = data;
    } catch (error: any) {
        console.error('Error fetching data:', error.message);
    }
});

watch(search, async () => {
    if (search.value !== null && search.value !== '' && search.value !== undefined) {
        // onMounted(async () => {
        try {
            const response = await fetch(`/api/tickets/filter-by-title/${search.value}`)
            if (!response.ok) {
                throw new Error('No available data');
            }
            const data = await response.json();
            responseData.value = data;
        } catch (error: any) {
            console.error('Error fetching data:', error.message);
        }
        // });
    } else {
        try {
            const response = await fetch('/api/tickets')
            if (!response.ok) {
                throw new Error('No available data');
            }
            const data = await response.json();
            responseData.value = data;
        } catch (error: any) {
            console.error('Error fetching data:', error.message);
        }
    }
});

</script>

<style lang="scss">
@import "@/assets/scss/variables.scss";

.ticket-page2 {
    $padding-inline: 40px;
    padding: 20px $padding-inline;

    min-height: 100%;

    font-size: 14px;
    line-height: 19.6px;

    form {
        input {
            all: unset;
            background-color: #2c3238;
            border: 2px solid #A6C5E229;
            padding: 1px 6px;
        }
    }

    .searchbar {
        display: flex;
        justify-content: flex-start;
        margin-top: 20px;
        margin-bottom: 8px;

        form {
            color: white;
            background: #ffffff11;
            backdrop-filter: blur(10px);
            display: flex;
            justify-content: space-between;
            // padding: 2px;
            border-radius: 6px;
            // width: 100%;
            // margin: 0 25px;

            input[type="search"] {
                border: none;
                background: transparent;
                margin: 0;
                padding: 8px 15px;
                font-family: inherit;
                // font-weight: 400;
                // font-size: 15px;
                color: inherit;
                border-radius: inherit;
            }

            input[type="search"]::placeholder {
                color: #fff;
                // font-weight: 400;
                // font-size: 15px;
            }

            button[type="submit"] {
                width: 40px;
                padding: 0;
                margin: 0;
                margin-right: 5px;
                border: none;
                border-radius: inherit;
                background: transparent url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='16' height='16' class='bi bi-search' viewBox='0 0 16 16'%3E%3Cpath d='M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z' fill='white'%3E%3C/path%3E%3C/svg%3E") no-repeat center;
                cursor: pointer;
                opacity: 0.7;
            }

            button[type="submit"]:hover {
                opacity: 1;
            }

            button[type="submit"]:focus,
            input[type="search"]:focus {
                // box-shadow: 0 0 3px 0 rgb(15, 171, 220);
                // border-color: #1183d6;
                outline: none;
            }

            button[type="submit"]:active {
                opacity: 0.7;
            }
        }
    }

    .search-options {
        font-size: 12px;
        width: fit-content;
        margin-bottom: 20px;
        margin-left: 5px;
        transition: $trans-01;

        .inter {
            display: flex;
            align-items: center;
            gap: 7px;
            cursor: pointer;
            transition: $trans-01;

            &:hover {
                text-decoration: underline;
            }

            span {
                display: flex;
                align-items: center;
                line-height: 12px;

                &.icon {
                    rotate: 90deg;
                    height: 9px;
                    width: 9px;
                    transform: translateX(1px);
                    fill: #B6C2CF;
                    transition: $trans-01;

                    &.active {
                        rotate: -90deg;
                        transform: translateX(-2px);
                    }
                }
            }
        }

        .options {
            margin-top: 8px;
            display: flex;
            gap: 15px;

            // display: none;
            // transition: all 2s ease;

            // &.active {
            //     display: flex;
            // }

            span {
                display: flex;
                gap: 4px;
            }
        }
    }

    .ticket-grid {
        padding-top: 5px;

        .row {
            display: grid;
            grid-template-columns: repeat(auto-fill, calc(100% / 7)); // 14.28%
            grid-template-columns: 20% 14% 14% 10% 10% 16% 16%; // 14.28%
            padding: 0.5em 0.5em;

            &:hover:not(:first-child) {
                background-color: #A1BDD914;
                // transition: $trans-01;
            }

            &.header {
                border-bottom: 2px solid #A6C5E229;
                color: #fff;
            }

            .cell {
                padding-left: 8px;
            }
        }

        .ticket.head {
            font-weight: 500;
        }
    }
}
</style>


<!-- 
$brand-color: #4f46e5;

$bg-dark-100: #111827;
$bg-dark-200: #202837;
$bg-dark-300: #101012;
$bg-dark-400: #0f172a;

$btn-dark-100: #29333d;

$btn-hover-100: #1f2937;

$text-white-100: #fbfbfb;
$text-white-200: #9ca3af;
$text-white-300: #79808d;
 -->