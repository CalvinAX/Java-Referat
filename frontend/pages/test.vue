<template>
    <div class="home-wrapper">
        <Topbar />
        <div class="table-wrapper">
            <table class="ticket-table">
                <thead>
                    <tr class="table-head-row">
                        <th>ID</th>
                        <th>Subject</th>
                        <th>Status</th>
                        <th>Tags</th>
                        <th>Asignee</th>
                        <th>Priority</th>
                        <th>Created</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="ticket in testTableData">
                        <td>{{ ticket.id }}</td>
                        <td>{{ ticket.subject }}</td>
                        <td>
                            <div class="table-status-container">
                                <div class="ticket-status" :class="`status-${ticket.status}`"></div>
                                <p>{{ ticket.status }}</p>
                            </div>
                        </td>
                        <td>
                            <div class="table-tag-container">
                                <div v-for="tag in ticket.tags" class="table-tag"
                                    :style="`background-color: ${tag.bgColor}; color: ${tag.color};`">
                                    {{ tag.name }}
                                </div>
                            </div>
                        </td>
                        <td>{{ ticket.asignee }}</td>
                        <td>{{ ticket.priority }}</td>
                        <td>{{ ticket.created }}</td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<script setup lange="ts">
definePageMeta({ middleware: 'auth' })

definePageMeta({
    layout: 'sidebar',
    middleware: 'auth',
})

const { status, signOut } = useAuth();

const loggedIn = computed(() => status.value === 'authenticated');

async function handleSignOut() {
    await signOut();
}

const testTableData = [
    {
        id: 1,
        subject: 'Lorem ipsum dolor sit amet',
        status: 'Open',
        tags: [
            {
                name: 'Frontend',
                bgColor: 'lightseagreen',
                color: 'white',
            },
            {
                name: 'GO',
                bgColor: '#007d9c',
                color: 'white',
            },
            {
                name: 'Nuxt',
                bgColor: '#00DC82',
                color: 'white',
            },
        ],
        asignee: 'Luca-Matteo Malte Matilda Torlo Recke',
        priority: 'High',
        created: '10. October 2023',
    },
    {
        id: 2,
        subject: 'nonumy eirmod tempor invidunt ut',
        status: 'Test',
        tags: [
            {
                name: 'Backend',
                bgColor: 'lightcoral',
                color: 'white',
            },
            {
                name: 'GO',
                bgColor: '#007d9c',
                color: 'white',
            },
        ],
        asignee: 'Luca-Matteo Malte Matilda Torlo Recke',
        priority: 'High',
        created: '10. October 2023',
    },
    {
        id: 3,
        subject: 'At vero eos et accusam',
        status: 'Done',
        tags: [
            {
                name: 'Frontend',
                bgColor: 'lightseagreen',
                color: 'white',
            },
            {
                name: 'Backend',
                bgColor: 'lightcoral',
                color: 'white',
            },
        ],
        asignee: 'Luca-Matteo Malte Matilda Torlo Recke',
        priority: 'High',
        created: '10. October 2023',
    },
];

</script>

<style lang="scss">
@import "@/assets/scss/variables.scss";

.main-content {
    background-color: white !important;
    color: black !important;
}

.table-wrapper {
    width: 100%;
    margin: 32px;
}

.ticket-table {
    width: 100%;
    border-collapse: collapse;
    filter: drop-shadow(0 10px 8px rgb(0 0 0 / 0.04)) drop-shadow(0 4px 3px rgb(0 0 0 / 0.1));

    th {
        padding: 14px 24px;
        text-align: start;
        border-bottom: 1px solid #373e4b;
        font-weight: 600;
        background-color: #111827;
        color: #fbfbfb;
    }

    td {
        padding: 16px 24px;
        text-align: start;
        border-bottom: 1px solid #373e4b;
        background-color: #202837;
        color: #79808d;
    }

    thead tr:last-child th:first-child {
        border-top-left-radius: 10px;
    }

    thead tr:last-child th:last-child {
        border-top-right-radius: 10px;
    }

    tbody tr:last-child td:first-child {
        border-bottom-left-radius: 10px;
    }

    tbody tr:last-child td:last-child {
        border-bottom-right-radius: 10px;
    }

    tbody tr:last-child td {
        border: 0;
    }

    .table-tag-container {
        display: flex;
        justify-content: flex-start;
        align-items: center;

        .table-tag {
            padding: 4px 10px;
            border-radius: 12px;
            margin-right: 6px;
        }

        .tag-frontend {
            background-color: lightseagreen;
            border: 1px solid rgb(29, 124, 120);
        }

        .tag-backend {
            background-color: lightcoral;
            border: 1px solid rgb(168, 88, 88);
        }

        .tag-go {
            background-color: #007d9c;
            border: 1px solid #0ca8cf;
        }

        .tag-nuxt {
            background-color: #00DC82;
            border: 1px solid #0f8e59;
        }
    }

    .table-status-container {
        display: flex;
        justify-content: flex-start;
        align-items: center;

        p {
            margin: 0;
        }

        .ticket-status {
            height: 12px;
            width: 12px;
            margin-right: 6px;
            border-radius: 50%;
        }

        .status-Open {
            background-color: rgb(141, 206, 228);
        }

        .status-Test {
            background-color: orange;
        }

        .status-Done {
            background-color: lightgreen;
        }
    }
}
</style>